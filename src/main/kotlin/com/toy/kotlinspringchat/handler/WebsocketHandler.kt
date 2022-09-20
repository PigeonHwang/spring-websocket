package com.toy.kotlinspringchat.handler

import com.toy.kotlinspringchat.proto.Message
import com.toy.kotlinspringchat.proto.User
import com.toy.kotlinspringchat.repository.MessageLogRepository
import com.toy.kotlinspringchat.service.MessageLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicInteger

class WebsocketHandler: TextWebSocketHandler() {
    @Autowired
    private lateinit var messageLogRepository: MessageLogRepository

    private val sessionList = HashMap<WebSocketSession, User>()
    private var uids = AtomicInteger(0)

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        broadcastToOthers(session, Message.newBuilder().setMsgType("left").setUser(sessionList[session]).build())
        broadcastToOthers(session, Message.newBuilder().setMsgType("say").setData("[Admin]: " + sessionList[session]?.name + " has left").build())
        sessionList -= session
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val user = User.newBuilder()
        sessionList[session] = user.setId(0).setName("").build()
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        var byeBufferMsg = message.payload
        var protoMsg = Message.parseFrom(byeBufferMsg)

        when (protoMsg.msgType) {
            "join" -> {
                val user = User.newBuilder()
                    .setId(uids.getAndIncrement())
                    .setName(protoMsg.data)
                    .build()

                sessionList[session] = user

                sessionList.forEach {
                    emit(session, Message.newBuilder()
                        .setMsgType("join")
                        .setUser(it.value)
                        .build())
                }

                broadcastToOthers(session, Message.newBuilder()
                    .setMsgType("join")
                    .setUser(user)
                    .build())

                broadcast(Message.newBuilder()
                    .setMsgType("say").setData("[Admin]: " + user.name + " has joined")
                    .build())
            }
            "say" -> {
                var msg = Message.newBuilder()
                    .setMsgType("say")
                    .setData("[" + sessionList[session]?.name + "]: " + protoMsg.data)
                    .build()

                var message1 = com.toy.kotlinspringchat.model.Message()
                message1.data = msg.data
                messageLogRepository.save(message1)
                broadcast(msg)
            }
        }
    }

    private fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(BinaryMessage(ByteBuffer.wrap(msg.toByteArray())))
    private fun broadcast(msg: Message) = sessionList.forEach { emit(it.key, msg)}
    private fun broadcastToOthers(me: WebSocketSession, msg: Message) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }

}