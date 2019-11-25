package com.example.kotlinapplication.net.factory

import com.example.kotlinapplication.net.request.RequestBodyConverter
import com.example.kotlinapplication.net.response.ResponseBodyConverter
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:56
 *描述:
 */
class CustomConverterFactory(private val gson: Gson) : Converter.Factory(){

    companion object staticMethord{
        fun create(): CustomConverterFactory{
            return create(Gson())
        }

        fun create(gson: Gson): CustomConverterFactory {
            if (gson == null) throw NullPointerException("gson == null")
            return CustomConverterFactory(gson)
        }
    }

    override fun responseBodyConverter(type : Type, annotations : Array<Annotation>, retrofit : Retrofit): ResponseBodyConverter<out Any> {
        var adapter : TypeAdapter<*> = gson.getAdapter(TypeToken.get(type))
        return ResponseBodyConverter(gson,adapter,type)
    }

    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): RequestBodyConverter<out Any> {
        var adapter : TypeAdapter<*> = gson.getAdapter(TypeToken.get(type))
        return RequestBodyConverter(gson,adapter)
    }
}