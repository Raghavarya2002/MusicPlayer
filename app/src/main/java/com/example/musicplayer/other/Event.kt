package com.example.musicplayer.other

open class Event<out T>(privata val data: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {

    }
}