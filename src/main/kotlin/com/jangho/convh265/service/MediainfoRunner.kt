package com.jangho.convh265.service

import com.jangho.convh265.model.MediainfoParser
import com.jangho.convh265.model.NuProcessHandler
import com.zaxxer.nuprocess.NuProcessBuilder
import org.slf4j.LoggerFactory
import java.io.File
import java.util.concurrent.TimeUnit

class MediainfoRunner {

    companion object {
        val logger = LoggerFactory.getLogger(MediainfoRunner::class.java)
    }

    fun getMediainfo(file: File): MediainfoParser {
        logger.info("Analysing {}", file.absolutePath)

        val listener = NuProcessHandler()
        val pb = NuProcessBuilder(listener, "mediainfo", file.absolutePath)
        val process = pb.start()
        process.waitFor(0, TimeUnit.SECONDS)
        return MediainfoParser(listener.getResult())
    }
}
