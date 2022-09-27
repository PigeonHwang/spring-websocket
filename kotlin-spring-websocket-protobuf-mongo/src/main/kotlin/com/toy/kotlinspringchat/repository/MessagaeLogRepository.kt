package com.toy.kotlinspringchat.repository

import com.toy.kotlinspringchat.model.Message
import com.toy.kotlinspringchat.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@Repository
interface MessageLogRepository: MongoRepository<Message, String> {
    fun findMessageByMessageIdx(idx: Long): Message
}