package com.jangho.convh265.service

import com.jangho.convh265.model.FileInfo
import com.jangho.convh265.model.NuProcessHandler
import com.zaxxer.nuprocess.NuProcessBuilder
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class H265Converter {

    companion object {
        val logger = LoggerFactory.getLogger(H265Converter::class.java)
    }

    fun convert(fileInfo: FileInfo) {
        logger.info("Converting file to h.265 {}", fileInfo.getFileAbsolutePath())
        logger.info("FileInfo: {}", fileInfo.toString())

        val command = arrayListOf(
                "ffmpeg",
                "-i", fileInfo.getFileAbsolutePath(),
                "-c:v", "libx265",
                "-crf", "28",
                "-c:a", "aac",
                "-b:a", "${fileInfo.getAudioBitRate()}k",
                fileInfo.getResultFilePath()
        )

        val listener = NuProcessHandler().with(fileInfo)
        val pb = NuProcessBuilder(listener, command)
        val process = pb.start()
        process.waitFor(0, TimeUnit.SECONDS)
    }
}
