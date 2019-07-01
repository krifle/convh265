package com.jangho.convh265.model

import java.io.File

class FileInfo (val file: File, val mediainfoParser: MediainfoParser) {

    fun isNonH265(): Boolean {
        return mediainfoParser.isNonH265()
    }

    fun getFileAbsolutePath(): String {
        return file.absolutePath
    }

    fun getAudioBitRate(): Int {
        return mediainfoParser.getAudioBitRate()
    }

    fun getResultFilePath(): String {
        return file.absolutePath.replaceAfterLast(".", "") + ".conv." + file.extension
    }

    override fun toString(): String {
        return """
            {
                "fileAbsolutePath": "${file.absolutePath}",
                "isNonH265": ${mediainfoParser.isNonH265()},
                "audioBitRate": ${mediainfoParser.getAudioBitRate()}
            }
        """.trimIndent()
    }
}
