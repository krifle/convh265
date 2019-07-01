package com.jangho.convh265.service

import org.springframework.util.StringUtils
import java.io.File

class PathValidator {

    fun validateBasePath(basePath: String): File {
        if (StringUtils.isEmpty(basePath)) {
            throw IllegalArgumentException("Invalid argument basePath. basePath is empty.")
        }

        val actualFile = File(basePath)
        if (!actualFile.exists()) {
            throw IllegalArgumentException("Invalid directory path. File not exists.")
        }

        if (!actualFile.isDirectory) {
            throw IllegalArgumentException("Input base path is not directory.")
        }

        return actualFile
    }
}
