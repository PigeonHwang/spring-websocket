package com.toy.kotlinspringchat

import com.example.demo.MongoOffsetDateTimeReader
import com.example.demo.MongoOffsetDateTimeWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.Arrays

@Configuration
class MongoConfig {
    @Bean
    fun mongoCustomConversions(): MongoCustomConversions {
        return MongoCustomConversions(Arrays.asList(
            MongoOffsetDateTimeWriter(),
            MongoOffsetDateTimeReader()
        ))
    }
}