package com.toy.stompchat.controller

import com.toy.stompchat.proto.MessageProto
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.socket.BinaryMessage

@Controller
class ChatController {
    @MessageMapping("/join")
    @SendTo("/topic/join")
    fun sessionJoin(message: String) {
        MessageProto.parseDelimitedFrom(message)
    }
}