package com.example.kotlinapplication.net.response

import com.example.kotlinapplication.net.utils.ErrorCode
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.lang.RuntimeException
import java.lang.reflect.Type
import java.util.ArrayList

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:22
 *描述:
 */
class ResponseBodyConverter<T>(private val gson : Gson,private val adapter : TypeAdapter<T>,private var type: Type) : Converter<ResponseBody,T>{

    private val SUCCESS_CODE = "Success"

    override fun convert(value: ResponseBody): T? {
        var MEDIA_TYPE = MediaType.parse("text/html; charset=UTF-8")
        if(value.contentType()!! == MEDIA_TYPE){
            throw RuntimeException()
        }
        value.use { value ->
            return handleNetResult(value.string())
        }
    }

    private fun <T> handleNetResult(result : String) : T {
        var netResult : NetResult ? = null
        try {
            netResult = gson.fromJson(result, NetResult::class.java)
        } catch (e: Exception) {
            if(e.message!!.contains("Expected BEGIN_OBJECT but was STRING")){
                return result as T
            }else{
                throw e
            }
        }

        try {
            if (SUCCESS_CODE == netResult.status) {
                if (type.toString() == EmptyResultBean::class.java!!.toString()) {
                    //如果是空的内容
                    return EmptyResultBean() as T
                }
                if (netResult.content == null) {
                    //如果为空
                    //因为 type.getTypeName()需要在28以上版本
                    val classPath = type.toString().replace("class", "").replace(" ", "")
                    if ("java.util.List<java.lang.String>" == classPath) {
                        return ArrayList<String>() as T
                    }
                    return if (classPath.startsWith("java.util.List")) {
                        val list = ArrayList<Any>()
                        list as T
                    } else {
                        val mClass = Class.forName(classPath)
                        mClass.getConstructor().newInstance() as T
                    }
                }
                return adapter.read(gson.newJsonReader(InputStreamReader(ByteArrayInputStream(gson.toJson(netResult.content).toByteArray())))) as T
            } else {
                throw ResponseException(netResult.errorCode, netResult.errorMsg)
            }
        } catch (e: Exception) {
            if (e is ResponseException) {
                throw ResponseException(netResult.errorCode, netResult.errorMsg)
            } else {
                throw ResponseException(ErrorCode.DATA_PARSE_ERROR, "数据解析出错" + e.message)
            }
        }
    }
}