package com.jangho.convh265.model

class TimeMessage(time: String) {
    val hour: Int
    val min: Int
    val sec: Double

    init {
        val splited = time.split(":")
        hour = splited[0].toInt()
        min = splited[1].toInt()
        sec = splited[2].toDouble()
    }
}
