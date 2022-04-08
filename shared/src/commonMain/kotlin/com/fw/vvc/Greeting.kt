package com.fw.vvc

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}