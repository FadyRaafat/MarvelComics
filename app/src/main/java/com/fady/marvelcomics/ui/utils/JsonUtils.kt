package com.fady.marvelcomics.ui.utils

import android.content.Context
import java.io.InputStream

class JsonUtils {

    private val globalPath: String = "json/"

    fun getJson(context: Context, path: String): String {
        // Load the JSON response
        val path = globalPath + path
        val inputStream = context.classLoader.getResourceAsStream(path)

        return convertStreamToString(inputStream)
    }

    fun getJson(classLoader: ClassLoader?, path: String): String {
        // Load the JSON response
        val path = globalPath + path
        val inputStream = classLoader?.getResourceAsStream(path)

        return convertStreamToString(inputStream)
    }

    @Throws(Exception::class)
    fun convertStreamToString(inputStream: InputStream?): String {
        return inputStream?.bufferedReader().use { bufferReader ->
            bufferReader?.readText() ?: ""
        }
    }
}