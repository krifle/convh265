package com.jangho.convh265.model

enum class VideoFiles {
    MP4,
    AVI,
    MOV,
    FLV,
    WMV,
    MKV;

    companion object {
        fun isVideoExtension(fileName: String): Boolean {
            values().forEach {
                if (it.name == fileName.toUpperCase()) {
                    return true
                }
            }
            return false
        }
    }
}
