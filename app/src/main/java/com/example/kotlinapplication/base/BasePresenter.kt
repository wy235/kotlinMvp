package com.example.kotlinapplication.base

import android.content.Context

/**
 *作者:wangyu
 *创建时间:2019/11/21 10:24
 *描述:
 */
open abstract class  BasePresenter<V,M>(var mContext: Context,var mView: V,var mModel: M) {

}
