package com.toy.kotlinspringchat.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Transient
const val MESSAGELOG_SEQUENCE_NAME = "message_log"

@Document(collection = "message_log")
class Message: BaseDocument() {
    @Id
    lateinit var id: String
    @Field("message_idx")
    var messageIdx: Long = 0
    @Field("user_id")
    lateinit var userId: String
    @Field("data")
    lateinit var data: String
}