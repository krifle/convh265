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
        if (fileInfo == null) {
            logger.error(String(bytes))
            super.onStderr(buffer, closed)
            return
        }
        val message = String(bytes)
        // TODO message 파싱해서 eta. 계산 필요
        //frame= 2452 fps=100 q=-0.0 size=    4697kB time=00:01:42.63 bitrate= 374.9kbits/s speed= 4.2x

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
