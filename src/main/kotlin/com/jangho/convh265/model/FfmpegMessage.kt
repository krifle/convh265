package com.jangho.convh265.model

class FfmpegMessage(message: String) {

    companion object {
        private const val FRAME_HEAD = "frame="
        private const val Q_HEAD = "q="
        private const val FPS_HEAD = "fps="
        private const val SIZE_HEAD = "size="
        private const val TIME_HEAD = "time="
        private const val BIT_RATE_HEAD = "bitrate="
        private const val SPEED_HEAD = "speed="
    }

    val frame: Long
    val fps: Int
    val size: Long // byte
    val time: TimeMessage
    val bitRate: String // DDD.Dkbits/s
    val speed: String // D.Dx

    init {
        frame = parseFrame(message)
        fps = parseFps(message)
        size = parseSize(message)
        time = parseTime(message)
        bitRate = parseBitRate(message)
        speed = parseSpeed(message)
    }

    private fun parseFrame(message: String): Long {
        val start = message.indexOf(FRAME_HEAD) + FRAME_HEAD.length
        val end = message.indexOf(FPS_HEAD)
        return message.substring(startIndex = start, endIndex = end).trim().toLong()
    }

    private fun parseFps(message: String): Int {
        val start = message.indexOf(FPS_HEAD) + FPS_HEAD.length
        val end = message.indexOf(Q_HEAD)
        return message.substring(startIndex = start, endIndex = end).trim().toInt()
    }

    private fun parseSize(message: String): Long {
        val start = message.indexOf(SIZE_HEAD) + SIZE_HEAD.length
        val end = message.indexOf(TIME_HEAD)
        val sizeAsString = message.substring(startIndex = start, endIndex = end).trim()
        return sizeAsString.replace(oldValue = "kB", newValue = "", ignoreCase = true).toLong() * 1024
    }

    private fun parseTime(message: String): TimeMessage {
        val start = message.indexOf(TIME_HEAD) + TIME_HEAD.length
        val end = message.indexOf(BIT_RATE_HEAD)
        return TimeMessage(message.substring(startIndex = start, endIndex = end).trim())
    }

    private fun parseBitRate(message: String): String {
        val start = message.indexOf(BIT_RATE_HEAD) + BIT_RATE_HEAD.length
        val end = message.indexOf(SPEED_HEAD)
        return message.substring(startIndex = start, endIndex = end).trim()
    }

    private fun parseSpeed(message: String): String {
        val start = message.indexOf(SPEED_HEAD) + SPEED_HEAD.length
        return message.substring(startIndex = start).trim()
    }
}
