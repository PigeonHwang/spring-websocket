package com.toy.kotlinspringchat.model

import com.toy.kotlinspringchat.proto.UserProto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Transient
const val USER_SEQUENCE_NAME = "users"

@Document(collection = "users")
class User:BaseDocument() {
    @Id
    lateinit var id: String
    @Field("user_idx")
    var userIdx: Long = 0
    @Field("user_name")
    lateinit var userName: String

    fun parseFromProto(userProto: UserProto): User {
        this.userIdx = userProto.idx
        this.userName = userProto.name
        return this
    }

    fun toProto(): UserProto {
        return UserProto.newBuilder()
            .setIdx(this.userIdx)
            .setName(this.userName)
            .build()
    }
}