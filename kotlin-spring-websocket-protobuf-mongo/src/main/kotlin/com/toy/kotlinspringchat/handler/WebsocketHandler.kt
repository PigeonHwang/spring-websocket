package com.toy.kotlinspringchat.handler

import com.toy.kotlinspringchat.model.User
import com.toy.kotlinspringchat.proto.MessageProto
import com.toy.kotlinspringchat.proto.MsgTypeEnum
import com.toy.kotlinspringchat.service.ChatService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.BinaryWebSocketHandler
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.nio.ByteBuffer

class WebsocketHandler(chatService: ChatService): BinaryWebSocketHandler() {
    private val sessionList = HashMap<WebSocketSession, User>()
    private var chatService = chatService
    val mutex = Mutex()

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        var msg = MessageProto.newBuilder()
        GlobalScope.launch {
            val mutex = Mutex()
            mutex.lock()
            /*coroutineBroadcastToOthers(session, msg.setMsgType(MsgTypeEnum.LEFT).setUser(sessionList[session]?.toProto()).build())
            coroutineBroadcastToOthers(session, msg.setMsgType(MsgTypeEnum.SAY).setData("[Admin]: " + sessionList[session]?.userName + " has left").build())*/
            /*broadcastToOthers(session, msg.setMsgType(MsgTypeEnum.LEFT).setUser(sessionList[session]?.toProto()).build())
            broadcastToOthers(session, msg.setMsgType(MsgTypeEnum.SAY).setData("[Admin]: " + sessionList[session]?.userName + " has left").build())*/
            mutex.unlock()
            sessionList -= session
        }
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessionList[session] = User()
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        var byteBufferMsg = message.payload
        var protoMsg = MessageProto.parseFrom(byteBufferMsg)

        when (protoMsg.msgType) {
            MsgTypeEnum.JOIN -> {
                var users = chatService.findUsersByUserName(protoMsg.data)

                var user: User = if(users.isEmpty()) {
                    chatService.createUser(protoMsg.data)
                } else {
                    users[0]
                }
                sessionList[session] = user

                sessionList.filter { it.value.userName == user.userName && it.key != session }.forEach {
                        it.key.close()
                    }

                sessionList.forEach {
                    emit(session,
                        MessageProto.newBuilder()
                            .setMsgType(MsgTypeEnum.JOIN)
                            .setUser(it.value.toProto())
                            .build()
                    )
                }

                GlobalScope.launch {
                    coroutineBroadcastToOthers(session, MessageProto.newBuilder()
                        .setMsgType(MsgTypeEnum.JOIN)
                        .setUser(user.toProto())
                        .build())
                    coroutineBroadcast(MessageProto.newBuilder()
                        .setMsgType(MsgTypeEnum.SAY)
                        .setData("[Admin]: " + user.userName + " has joined")
                        .build())
                }
                /*broadcastToOthers(session, MessageProto.newBuilder()
                    .setMsgType(MsgTypeEnum.JOIN)
                    .setUser(user.toProto())
                    .build())

                broadcast(MessageProto.newBuilder()
                    .setMsgType(MsgTypeEnum.SAY)
                    .setData("[Admin]: " + user.userName + " has joined")
                    .build())*/
            }
            MsgTypeEnum.SAY -> {
                GlobalScope.launch {
                    var msg = MessageProto.newBuilder()
                        .setMsgType(MsgTypeEnum.SAY)
                        .setData("[" + sessionList[session]?.userName + "]: " + protoMsg.data)
                        .build()
                    chatService.createMessage(msg, sessionList[session]!!)
                    coroutineBroadcast(msg)
                }
            }
        }
    }

    private fun emit(session: WebSocketSession, msg: MessageProto) = session.sendMessage(BinaryMessage(ByteBuffer.wrap(msg.toByteArray())))
    private fun broadcast(msg: MessageProto) = sessionList.forEach { emit(it.key, msg)}
    private fun broadcastToOthers(me: WebSocketSession, msg: MessageProto) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }

    fun CoroutineScope.coroutineBroadcastToOthers(me: WebSocketSession, msg: MessageProto) {
        val others = sessionList.filterNot { it.key == me }

        others.forEach {
            launch {
                emit(it.key, msg)
            }
        }
    }

    fun CoroutineScope.coroutineBroadcast(msg: MessageProto) {
        sessionList.forEach {
            launch {
                emit(it.key,msg)
                println(it.value.userName)
            }
        }
    }

}