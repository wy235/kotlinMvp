package com.example.kotlinapplication.net.response

import java.lang.RuntimeException

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:44
 *描述:
 */
class ResponseException(var code: String?, override var message: String?) : RuntimeException(message)