package com.jangho.convh265.model

import com.zaxxer.nuprocess.NuAbstractProcessHandler
import com.zaxxer.nuprocess.NuProcess
import org.slf4j.LoggerFactory
import java.nio.ByteBuffer

class NuProcessHandler: NuAbstractProcessHandler() {

    companion object {
        val logger = LoggerFactory.getLogger(NuProcessHandler::class.java)
    }

    private lateinit var nuProcess: NuProcess
    private lateinit var fileInfo: FileInfo

    private val resultBuilder = StringBuilder()

    fun with(fileInfo: FileInfo): NuProcessHandler {
        this.fileInfo = fileInfo
        return this
    }

    fun getResult(): String {
        return resultBuilder.toString()
    }

    override fun onStart(nuProcess: NuProcess?) {
        this.nuProcess = nuProcess!!
    }

    override fun onStderr(buffer: ByteBuffer?, closed: Boolean) {
        val bytes = ByteArray(buffer!!.remaining())
        buffer.get(bytes)
        val ffmpegMessage = FfmpegMessage(String(bytes))

        super.onStderr(buffer, closed)
    }

    override fun onStdout(buffer: ByteBuffer?, closed: Boolean) {
        if (closed) {
            return
        }

        val bytes = ByteArray(buffer!!.remaining())
        buffer.get(bytes)

        val stringChunk = String(bytes)
        logger.debug(stringChunk)
        resultBuilder.append(stringChunk)

        nuProcess.closeStdin(true)
    }
}
