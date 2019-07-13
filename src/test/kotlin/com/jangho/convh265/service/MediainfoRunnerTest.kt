package com.jangho.convh265.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

class MediainfoRunnerTest {

    private val sut = MediainfoRunner()

    @Test
    fun getMediainfo_h264_동작_테스트() {
        // given
        val file = File("C:\\Users\\k_rif\\Downloads\\kaguya\\1.mp4")

        // when
        val result = sut.getMediainfo(file)

        // then
        assertThat(result.isH265()).isFalse()
    }

    @Test
    fun getMediainfo_h265_동작_테스트() {
        // given
        val file = File("C:\\Users\\k_rif\\Downloads\\kaguya\\Kaguya-sama wa Kokurasetai - 10 (1920x1080 HEVC2 AAC).mkv")

        // when
        val result = sut.getMediainfo(file)

        // then
        assertThat(result.isH265()).isTrue()
    }
}
