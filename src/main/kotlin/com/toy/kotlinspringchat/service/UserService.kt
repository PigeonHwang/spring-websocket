package com.toy.kotlinspringchat.service

import com.toy.kotlinspringchat.model.USER_SEQUENCE_NAME
import com.toy.kotlinspringchat.model.User
import com.toy.kotlinspringchat.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var dbSequenceService: DbSequenceService

    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun findUserByIdx(input: Long): User {
        return userRepository.findUserByUserIdx(input)
    }

    fun createUser(userInput: User): User {
        var user = User()
        user.userIdx = dbSequenceService.generateSequence(USER_SEQUENCE_NAME)
        user.userName = userInput.userName
        user.password = userInput.password
        return userRepository.save(user)
    }

    fun updateUser(userIdxInput: Long, userInput: User): User {
        var user = findUserByIdx(userIdxInput)
        user.userName = userInput.userName
        user.password = userInput.password
        return userRepository.save(user)
    }

    fun deleteUser(userIdxInput: Long): User {
        return userRepository.deleteByUserIdx(userIdxInput)
    }
}