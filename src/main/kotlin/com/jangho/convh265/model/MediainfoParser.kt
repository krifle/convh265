package com.jangho.convh265.model

import com.jangho.convh265.model.MediainfoCategory.*
import org.apache.commons.lang3.math.NumberUtils
import org.slf4j.LoggerFactory
import java.util.regex.Pattern

class MediainfoParser(result: String) {

    companion object {
        private const val UNKNOWN = "UNKNOWN"
        private const val DEFAULT_AUDIO_BIT_RATE = 128

        private val logger = LoggerFactory.getLogger(MediainfoParser::class.java)
    }

    private val resultList: List<String> = result.split("\n")
    private val duration = parseDuration(resultList)
    private val videoFormat = parseVideoFormat(resultList)
    private val videoWritingLibrary = parseVideoWritingLibrary(resultList)
    private val audioBitRate = parseAudioBitrate(resultList)

    private fun parseDuration(lines: List<String>): String {
        // general 의 Duration                                 : 1 h 32 min
        TODO()
    }

    private fun parseVideoFormat(lines: List<String>): String {
        var currentCategory = NONE
        lines.forEach {
            currentCategory = findCurrentCategory(it, currentCategory)

            if (currentCategory == VIDEO && isKeyValueForm(it) && parseKey(it).toUpperCase() == "FORMAT") {
                return parseValue(it)
            }
        }
        return UNKNOWN
    }

    private fun parseVideoWritingLibrary(lines: List<String>): String {
        var currentCategory = NONE
        lines.forEach {
            currentCategory = findCurrentCategory(it, currentCategory)

            if (currentCategory == VIDEO && isKeyValueForm(it) && parseKey(it).toUpperCase() == "WRITING LIBRARY") {
                return parseValue(it)
            }
        }
        return UNKNOWN
    }

    private fun parseAudioBitrate(lines: List<String>): String {
        var currentCategory = NONE
        lines.forEach {
            currentCategory = findCurrentCategory(it, currentCategory)

            if (currentCategory == AUDIO && isKeyValueForm(it) && parseKey(it).toUpperCase() == "BIT RATE") {
                logger.info("AudioBitRate: {}", parseValue(it))
                return parseValue(it)
            }
        }
        return UNKNOWN
    }

    private fun findCurrentCategory(line: String, current: MediainfoCategory): MediainfoCategory {
        val foundCategory = MediainfoCategory.findCategory(line)
        return if (foundCategory != NONE) {
            foundCategory
        } else {
            current
        }
    }

    private fun parseKey(line: String): String {
        validateLineAsKeyValueForm(line)
        return line.split(":").first().trim()
    }

    private fun parseValue(line: String): String {
        validateLineAsKeyValueForm(line)
        return line.split(":").drop(1).joinToString("").trim()
    }

    private fun validateLineAsKeyValueForm(line: String) {
        if (!line.contains(":")) {
            throw IllegalArgumentException("This line is not in key-value form ${line}")
        }
    }

    private fun isKeyValueForm(line: String): Boolean {
        return line.contains(":")
    }

    fun isH265(): Boolean {
        return videoFormat.toUpperCase().contains("HEVC") &&
                videoWritingLibrary.toUpperCase().contains("X265")
    }

    fun isNonH265(): Boolean {
        return !isH265()
    }

    fun getAudioBitRate(): Int {
        val matcher = Pattern.compile("-?\\d+|\\.").matcher(audioBitRate)
        var numberString = ""
        while(matcher.find()) {
            numberString += matcher.group()
        }

        if (numberString.isNotEmpty() && NumberUtils.isParsable(numberString)) {
            return numberString.toDouble().toInt()
        }

        return DEFAULT_AUDIO_BIT_RATE
    }
}
