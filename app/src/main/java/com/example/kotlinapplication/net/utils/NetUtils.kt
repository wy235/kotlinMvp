package com.example.kotlinapplication.net.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.kotlinapplication.KotlinApplication
import okhttp3.Request

/**
 *作者:wangyu
 *创建时间:2019/11/21 13:52
 *描述:
 */
class NetUtils {

    companion object StaticMethords{

        val TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJkMjUzNTZhNWU2ZDE1MTlmNTliODQ1NGM0ZGU3MmEzMmZjZWEwMDMyIiwiZGV2aWNlR3JvdXAiOiJBUFAiLCJpcCI6IjExOC4xMTIuNTguNzciLCJpc3MiOiJaWVBfU1NPIiwidXNlciI6IntcImFwcElkXCI6XCIxMFwiLFwiZGV2aWNlVHlwZVwiOlwiQU5EUk9JRFwiLFwiZW1haWxcIjpcIndhbmdqdWUxMTAyQHFxLmNvbVwiLFwiaGVhZEltZ1wiOlwiaHR0cHM6Ly96eXAtZmFybS0yLm9zcy1hcC1zb3V0aGVhc3QtMS5hbGl5dW5jcy5jb20vZGF0YS93b3JsZC11c2VyL2hlYWRJbWcvMTU2MDk5NjU0NzYwOC5qcGdcIixcImlkXCI6XCIxNzZcIixcInBhc3N3b3JkXCI6XCJiN2RiOTUzMmUzMGUxNTVhMGMwOTU2OTZiOTkxNTE4OTA3NzBhMzUzODhmNDM0N2ZcIixcInVzZXJOYW1lXCI6XCLpmpTlo4HogIHnjotcIn0iLCJpYXQiOjE1NzQ2NTMyNjZ9.vatOB6orgufd4OKCTPT6alTaMtEiLuk8l5e3ruWA-pSqmmTIZeBBuIeH4kV2R6k-4CbohdFXSqGpJyD_oSqS8w"

        //检测是否有网
        fun isNetworkConnected() : Boolean{
            var mConnectivityManager : ConnectivityManager = KotlinApplication.getContext()!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var mNetworkInfo : NetworkInfo = mConnectivityManager.activeNetworkInfo
            if(mNetworkInfo != null){
                return mNetworkInfo.isAvailable
            }
            return false
        }

        fun getNetHeader(builder : Request.Builder) : Request.Builder{
            builder.addHeader("Content-Type","application/x-www-form-urlencoded")
                    .addHeader("Content-Length", "13")
                    .addHeader("User-Agent","Dalvik/2.1.0 (Linux; U; Android 8.0.0; LDN-AL00 Build/HUAWEILDN-AL00)")
                    .addHeader("Accept-Language","zh")
                    .addHeader("_Device-Id_","d25356a5e6d1519f59b8454c4de72a32fcea0032")
                    .addHeader("_Device-Type_","Android")
                    .addHeader("_App-Version_","v1.2.5")
                    .addHeader("_Sys-Version_","26")
                    .addHeader("content-type", "application/json; charset=utf-8")
                    .addHeader("Transfer-Encoding","chunked")
                    .addHeader("Cache-Control","no-store")
            return builder
        }
    }
}