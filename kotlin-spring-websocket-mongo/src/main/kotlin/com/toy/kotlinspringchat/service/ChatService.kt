package com.toy.kotlinspringchat.service

import com.toy.kotlinspringchat.model.MESSAGELOG_SEQUENCE_NAME
import com.toy.kotlinspringchat.model.Message
import com.toy.kotlinspringchat.model.USER_SEQUENCE_NAME
import com.toy.kotlinspringchat.model.User
import com.toy.kotlinspringchat.proto.MessageArrProto
import com.toy.kotlinspringchat.proto.MessageProto
import com.toy.kotlinspringchat.repository.MessageLogRepository
import com.toy.kotlinspringchat.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatService {
    @Autowired
    private lateinit var messageLogRepository: MessageLogRepository
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var dbSequenceService: DbSequenceService

    fun findAllMessage(): List<Message> {
        return messageLogRepository.findAll()
    }

    fun findAllMessageAsProto(): MessageArrProto {
        var msgList = findAllMessage()
        var msgArrProto = MessageArrProto.newBuilder()
        msgList.forEach {
            msgArrProto.addMsgList(it.toProto())
        }
        return msgArrProto.build()
    }

    fun createMessage(msgProto: MessageProto, user: User): Message {
        var message = Message()
        message.messageIdx = dbSequenceService.generateSequence(MESSAGELOG_SEQUENCE_NAME)
        message.messageType = msgProto.msgType
        message.data = msgProto.data
        message.userName = user.userName
        return messageLogRepository.save(message)
    }

    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun findUserByIdx(userIdx: Long): User {
        return userRepository.findUserByUserIdx(userIdx)
    }

    fun createUser(userName: String): User {
        var user = User()
        user.userIdx = dbSequenceService.generateSequence(USER_SEQUENCE_NAME)
        user.userName = userName
        return userRepository.save(user)
    }

    fun updateUser(userIdx: Long, userInput: User): User {
        var user = findUserByIdx(userIdx)
        user.userName = userInput.userName
        return userRepository.save(user)
    }

    fun deleteUser(userIdx: Long): User {
        return userRepository.deleteByUserIdx(userIdx)
    }

    fun findUsersByUserName(userName: String): List<User> {
        return userRepository.findUsersByUserName(userName)
    }
}