package com.toy.kotlinspringchat.model

import com.toy.kotlinspringchat.proto.MessageProto
import com.toy.kotlinspringchat.proto.MsgTypeEnum
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
    @Field("message_type")
    lateinit var messageType: MsgTypeEnum
    @Field("user_name")
    lateinit var userName: String
    @Field("data")
    lateinit var data: String

    fun parseFromProto(messageProto: MessageProto): Message {
        this.messageType = messageProto.msgType
        this.userName = messageProto.user.name
        this.data = messageProto.data
        return this
    }

    fun toProto(): MessageProto {
        return MessageProto.newBuilder()
            .setMsgType(this.messageType)
            .setData(this.data)
            .setDate(this.createdAt.toEpochSecond())
            .build()
    }
}