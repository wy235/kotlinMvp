package com.example.kotlinapplication.net.utils

import android.text.TextUtils
import java.util.*

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:07
 *描述:
 */
class ApiParams : HashMap<String, Any> {

    constructor()

    constructor(key: String, value: Any) {
        put(key, value)
    }

    fun with(key: String, value: Any): ApiParams {
        put(key, value)
        return this
    }

    fun widthCheckNull(key: String, value: Any?): ApiParams {
        if (value is String) {
            if (value != null) {
                val valueStr = value.toString()
                if (!TextUtils.isEmpty(valueStr) && !TextUtils.equals("null", valueStr)) {
                    put(key, value)
                }
            }
        }
        return this
    }
}