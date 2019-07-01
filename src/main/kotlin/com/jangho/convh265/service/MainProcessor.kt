package com.jangho.convh265.service

import com.jangho.convh265.model.FileInfo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File

@Service
class MainProcessor {

    companion object {
        val logger = LoggerFactory.getLogger(MainProcessor::class.java)
    }

    val fileManager = FileManager()
    val mediaInfoRunner = MediainfoRunner()
    val h265Converter = H265Converter()

    fun process(baseDirectory: File) {
        logger.info("Staring scanning directory: {}", baseDirectory.absolutePath)

        val fileInfos = fileManager
                .scanDirectoryRecursive(baseDirectory)
                .map { FileInfo(it, mediaInfoRunner.getMediainfo(it)) }
                .filter { it.isNonH265() }

        logger.info("Total {} of files are detected.", fileInfos.size)
        logger.info("Working with files: {}", fileInfos.map { it.getFileAbsolutePath() })

        fileInfos.forEach {
            h265Converter.convert(it)
            // TODO 끝났으면 원본 파일은 지워주기
        }
    }
}
