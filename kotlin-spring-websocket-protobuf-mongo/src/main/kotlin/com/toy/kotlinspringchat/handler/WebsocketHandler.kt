package com.toy.kotlinspringchat.handler

import com.toy.kotlinspringchat.model.User
import com.toy.kotlinspringchat.proto.MessageProto
import com.toy.kotlinspringchat.proto.MsgTypeEnum
import com.toy.kotlinspringchat.service.ChatService
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.nio.ByteBuffer

class WebsocketHandler(chatService: ChatService): TextWebSocketHandler() {
    private val sessionList = HashMap<WebSocketSession, User>()
    private var chatService = chatService

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        var msg = MessageProto.newBuilder()
        broadcastToOthers(session, msg.setMsgType(MsgTypeEnum.LEFT).setUser(sessionList[session]?.toProto()).build())
        broadcastToOthers(session, msg.setMsgType(MsgTypeEnum.SAY).setData("[Admin]: " + sessionList[session]?.userName + " has left").build())
        sessionList -= session
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

                println("*****************")
                sessionList.forEach {
                    println(it.value.userName + " : " + it.key)
                }
                println(user.userName + " : " + session)
                println("*****************")

                sessionList.forEach {
                    if(it.value.userName == user.userName && !it.key.equals(session)) {
                        var s = it.key
                        s.close()
                    } else {
                        println("222")
                        emit(session, MessageProto.newBuilder()
                            .setMsgType(MsgTypeEnum.JOIN)
                            .setUser(it.value.toProto())
                            .build())
                    }
                }

                broadcastToOthers(session, MessageProto.newBuilder()
                    .setMsgType(MsgTypeEnum.JOIN)
                    .setUser(user.toProto())
                    .build())

                broadcast(MessageProto.newBuilder()
                    .setMsgType(MsgTypeEnum.SAY)
                    .setData("[Admin]: " + user.userName + " has joined")
                    .build())
            }
            MsgTypeEnum.SAY -> {
                var msg = MessageProto.newBuilder()
                    .setMsgType(MsgTypeEnum.SAY)
                    .setData("[" + sessionList[session]?.userName + "]: " + protoMsg.data)
                    .build()

                chatService.createMessage(msg, sessionList[session]!!)

                broadcast(msg)
            }
        }
    }

    private fun emit(session: WebSocketSession, msg: MessageProto) = session.sendMessage(BinaryMessage(ByteBuffer.wrap(msg.toByteArray())))
    private fun broadcast(msg: MessageProto) = sessionList.forEach { emit(it.key, msg)}
    private fun broadcastToOthers(me: WebSocketSession, msg: MessageProto) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }

}