package com.example.kotlinapplication

import android.app.Application
import android.content.Context

/**
 *作者:wangyu
 *创建时间:2019/11/21 13:38
 *描述:
 */
class KotlinApplication : Application(){

    companion object {
        var  mContext : Application ? = null
        fun getContext():Context{
            return mContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}