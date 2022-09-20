package com.toy.kotlinspringchat.service

import com.toy.kotlinspringchat.model.Message
import com.toy.kotlinspringchat.repository.MessageLogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class MessageLogService {
    @Autowired
    private lateinit var messageLogRepository: MessageLogRepository
    @Autowired
    private lateinit var dbSequenceService: DbSequenceService

    fun findAllMessage(): List<Message> {
        return messageLogRepository.findAll()
    }

    fun createMessage(messageInput: com.toy.kotlinspringchat.proto.Message): Message {
        var message = Message()
        message.data = messageInput.data
        return messageLogRepository.save(message)
    }
}