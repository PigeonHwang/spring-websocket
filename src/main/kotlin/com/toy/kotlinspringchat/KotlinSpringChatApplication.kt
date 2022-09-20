package com.toy.kotlinspringchat

import com.toy.kotlinspringchat.repository.MessageLogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
class KotlinSpringChatApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringChatApplication>(*args)
}
