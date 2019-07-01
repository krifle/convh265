package com.jangho.convh265.service

import com.jangho.convh265.model.FileInfo
import org.junit.Test
import java.io.File

class H265ConverterTest {

    private val sut = H265Converter()
    private val mediainfoRunner = MediainfoRunner()

    @Test
    fun convertTest() {
        // given
        val target = File("C:\\Users\\k_rif\\Downloads\\LUPIN_III_TV_SPECIALS_MOVIES_OVAS\\안녕 하세 요.mkv")
        val fileInfo = FileInfo(target, mediainfoRunner.getMediainfo(target))

        // when // then
        sut.convert(fileInfo)
    }
}
