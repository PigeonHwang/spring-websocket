package com.example.demo

import com.example.proto.Message
import com.example.proto.User
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicInteger

class WsHandlerProto: TextWebSocketHandler() {
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
                broadcast(Message.newBuilder()
                    .setMsgType("say")
                    .setData("[" + sessionList[session]?.name + "]: " + protoMsg.data)
                    .build())
            }
        }
    }

    private fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(BinaryMessage(ByteBuffer.wrap(msg.toByteArray())))
    private fun broadcast(msg: Message) = sessionList.forEach { emit(it.key, msg)}
    private fun broadcastToOthers(me: WebSocketSession, msg: Message) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }

}