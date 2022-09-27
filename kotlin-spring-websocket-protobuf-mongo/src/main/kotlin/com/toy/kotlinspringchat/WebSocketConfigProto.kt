package com.toy.kotlinspringchat

import com.toy.kotlinspringchat.handler.WebsocketHandler
import com.toy.kotlinspringchat.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfigProto: WebSocketConfigurer {
    @Autowired
    private lateinit var chatService: ChatService

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry
            .addHandler(WebsocketHandler(chatService), "/chat")
            .setAllowedOriginPatterns("*")
    }
}