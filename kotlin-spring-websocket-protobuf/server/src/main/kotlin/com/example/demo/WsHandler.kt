package com.example.demo

import com.example.model.Message
import com.example.model.User
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.atomic.AtomicLong

class WsHandler: TextWebSocketHandler() {
    private val sessionList = HashMap<WebSocketSession, User>()
    private var uids = AtomicLong(0)

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        GlobalScope.launch {
            val user = sessionList[session]!!
            sessionList -= session
            sessionList.forEach {
                launch {
                    emit(it.key, Message("left", user))
                    emit(it.key, Message("say", user.name + " 님께서 퇴장하셨습니다."))
                }
            }
        }
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val user = User(0, "")
        sessionList[session] = user
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val json = ObjectMapper().readTree(message.payload)

        when (json.get("type").asText()) {
            "join" -> {
                val user = User(uids.getAndIncrement(), json.get("data").asText())
                sessionList[session] = user
                emit(session, Message("users", sessionList.values))
                GlobalScope.launch {
                    sessionList.forEach {
                        launch {
                            if(it.key != session) emit(it.key, Message("join", user))
                            emit(it.key, Message("say", sessionList[session]?.name + " 님께서 입장하셨습니다."))
                        }
                    }
                }
            }
            "say" -> {
                GlobalScope.launch {
                    coroutineBroadcast(Message("say", "[" + sessionList[session]?.name + "]: " + json.get("data").asText()))
                }
            }
        }
    }

    private fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(TextMessage(jacksonObjectMapper().writeValueAsString(msg)))
    fun broadcast(msg: Message) = sessionList.forEach { emit(it.key, msg) }
    fun broadcastToOthers(me: WebSocketSession, msg: Message) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }

    private fun CoroutineScope.coroutineBroadcast(msg: Message) {
        sessionList.forEach {
            launch {
                emit(it.key,msg)
            }
        }
    }

    private fun CoroutineScope.coroutineBroadcastToOthers(me: WebSocketSession, msg: Message) {
        val others = sessionList.filterNot { it.key == me }
        others.forEach {
            launch {
                emit(it.key, msg)
            }
        }
    }
}