package com.example.kotlinapplication.net.utils

/**
 *作者:wangyu
 *创建时间:2019/11/21 15:51
 *描述:
 */
class ErrorCode {

    companion object staticFild{
        val DATA_PARSE_ERROR = "999999"//数据解析错误
        val PWD_ERROR_LOCK = "10010016"//密码错误次数超限，当前账户已被锁定
        val USER_ACCOUNT_FROST = "10010015"//账号冻结
        val USER_TOKEN_PAST = "10010019"//用户token过期
        val USER_TOKEN_INVALID = "10010018"//用户token无效
        val USER_TOKEN_KICK = "10010020"//您的账号在另一设备登录，您被迫下线
        val USER_RETRY_TOKEN_PASSWORD_ERROR = "10010029"//续接的时候 密码错误
        val USER_TOKEN_INVALID_TRY = "10000019"//用户token无效
        val USER_AUTO_LOGIN_ERROR = "10010021"//自动登录失败
    }
}