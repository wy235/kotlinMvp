package com.example.kotlinapplication.net.api

/**
 *作者:wangyu
 *创建时间:2019/11/25 13:36
 *描述:
 */
class BaseApi {

    companion object {
        val APP_BASEURL = "http://qa-gateway.worldfarm.com/world-koala"

        val CATTLE_DETEAL_URL = "$APP_BASEURL/mobile/cattle-search/detail"
    }
}