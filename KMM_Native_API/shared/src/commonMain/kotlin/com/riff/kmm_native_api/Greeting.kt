package com.riff.kmm_native_api

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}