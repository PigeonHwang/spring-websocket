package com.example.demo

class HelloMessage {
    private lateinit var name: String

    constructor() {}

    constructor(name: String) {
        this.name = name
    }

    fun getName(): String {
       return name
    }

    fun setName(name: String) {
        this.name = name
    }
}