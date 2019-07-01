package com.jangho.convh265.service

import com.jangho.convh265.model.VideoFiles
import org.apache.commons.io.FileUtils
import org.slf4j.LoggerFactory
import java.io.File

class FileManager {

    companion object {
        val logger = LoggerFactory.getLogger(FileManager::class.java)
    }

    fun scanDirectoryRecursive(baseDirectory: File): List<File> {
        val files = mutableListOf<File>()
        val iter = FileUtils.iterateFiles(baseDirectory, null, true)

        while (iter.hasNext()) {
            val curr = iter.next()
            if (curr.isDirectory) {
                continue
            }
            if (!VideoFiles.isVideoExtension(curr.extension)) {
                continue
            }

            files.add(curr)
        }

        return files.asSequence().toList()
    }
}
