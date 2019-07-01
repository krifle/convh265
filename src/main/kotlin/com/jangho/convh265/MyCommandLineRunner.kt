package com.jangho.convh265

import com.jangho.convh265.service.MainProcessor
import com.jangho.convh265.service.PathValidator
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class MyCommandLineRunner: CommandLineRunner {

    private val pathValidator = PathValidator()
    private val processManager = MainProcessor()

    companion object {
        val logger = LoggerFactory.getLogger(MyCommandLineRunner::class.java)
    }

    override fun run(vararg args: String?) {
        val basePath = args.get(0)
        if (basePath == null) {
            logger.error("Invalid parameter. The parameter is null. Terminating process.")
            return
        }

        val baseDirectory = pathValidator.validateBasePath(basePath)

        processManager.process(baseDirectory)
    }
}
