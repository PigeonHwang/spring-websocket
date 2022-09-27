package com.toy.kotlinspringchat.repository

import com.toy.kotlinspringchat.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findUserByUserIdx(idx: Long): User
    fun findUsersByUserName(userName: String): List<User>
    fun deleteByUserIdx(idx: Long): User
}