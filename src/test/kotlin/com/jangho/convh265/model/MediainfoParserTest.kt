package com.jangho.convh265.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MediainfoParserTest {

    @Test
    fun h265_결과_파싱하여_h265_여부_확인() {
        // given // when
        val result = MediainfoParser(MediainfoTestResult.h265Result)

        // then
        assertThat(result.isH265()).isTrue()
        assertThat(result.getAudioBitRate()).isEqualTo(128)
    }

    @Test
    fun h264_결과_파싱하여_h265_여부_확인() {
        // given // when
        val result = MediainfoParser(MediainfoTestResult.h264Result)

        // when
        assertThat(result.isH265()).isFalse()
        assertThat(result.getAudioBitRate()).isEqualTo(1024)
    }
}
