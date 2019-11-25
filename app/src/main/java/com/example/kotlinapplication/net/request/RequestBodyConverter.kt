package com.example.kotlinapplication.net.request

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.Buffer
import retrofit2.Converter
import java.io.OutputStreamWriter
import java.nio.charset.Charset

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:15
 *描述:
 */
class RequestBodyConverter<T>(private var gson: Gson,private var adapter: TypeAdapter<T>) : Converter<T, RequestBody> {

    companion object StaticMethords{
        private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")
        private val UTF_8 = Charset.forName("UTF-8")
    }

    override fun convert(value: T): RequestBody? {
        var buffer = Buffer()
        var writer = OutputStreamWriter(buffer.outputStream(), UTF_8)
        var jsonWriter = gson.newJsonWriter(writer)
        adapter.write(jsonWriter, value)
        jsonWriter.close()
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString())
    }
}