package com.jangho.convh265.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FfmpegMessageTest {

    @Test
    fun parseTest() {
        // given
        val message = "frame= 2452 fps=100 q=-0.0 size=    4697kB time=00:01:42.63 bitrate= 374.9kbits/s speed= 4.2x"

        // when
        val ffmpegMessage = FfmpegMessage(message)

        // then
        assertThat(ffmpegMessage.frame).isEqualTo(2452L)
        assertThat(ffmpegMessage.fps).isEqualTo(100)
        assertThat(ffmpegMessage.size).isEqualTo(4809728L)
        assertThat(ffmpegMessage.time.hour).isEqualTo(0)
        assertThat(ffmpegMessage.time.min).isEqualTo(1)
        assertThat(ffmpegMessage.time.sec).isEqualTo(42.63)
        assertThat(ffmpegMessage.bitRate).isEqualTo("374.9kbits/s")
        assertThat(ffmpegMessage.speed).isEqualTo("4.2x")
    }
}
