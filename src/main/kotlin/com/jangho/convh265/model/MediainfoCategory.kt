package com.jangho.convh265.model

enum class MediainfoCategory {
    NONE,
    GENERAL,
    VIDEO,
    AUDIO,
    TEXT;

    companion object {
        fun findCategory(line: String): MediainfoCategory {
            values().forEach {
                if (line.trim().toUpperCase().startsWith(it.name)) {
                    return it
                }
            }
            return NONE
        }
    }
}
