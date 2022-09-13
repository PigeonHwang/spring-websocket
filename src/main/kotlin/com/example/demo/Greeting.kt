package com.example.demo

class Greeting {
    private lateinit var content: String

    constructor() {}

    constructor(content: String) {
        this.content = content
    }

    fun getContent(): String {
        return content
    }
}