package com.jangho.convh265.service

import org.junit.Test
import java.io.File

class FileManagerTest {

    val sut = FileManager()

    @Test
    fun scanDirectoryRecursive() {
        // given
        val baseDirectory = File("C:\\Users\\k_rif\\Downloads\\kaguya")

        // when
        val result = sut.scanDirectoryRecursive(baseDirectory)

        // then
        result.forEach {
            println(it.absolutePath)
        }
    }
}
