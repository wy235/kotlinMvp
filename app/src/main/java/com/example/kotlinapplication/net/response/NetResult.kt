package com.example.kotlinapplication.net.response

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:33
 *描述:
 */
class NetResult {

    //错误状态码
    var errorCode : String ? = null
    //错误提示信息
    var errorMsg : String ? = null
    //数据内容
    var content : Any ? = null
    //状态
    var status : String ? = null
}