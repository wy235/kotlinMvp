package com.example.kotlinapplication.ui.presenter

import android.content.Context
import com.example.kotlinapplication.base.BasePresenter
import com.example.kotlinapplication.net.subscribe.ResponseSubscribe
import com.example.kotlinapplication.net.utils.ApiParams
import com.example.kotlinapplication.ui.bean.LivestockBean
import com.example.kotlinapplication.ui.model.MainModel
import com.example.kotlinapplication.ui.view.MainView

/**
 *作者:wangyu
 *创建时间:2019/11/21 16:49
 *描述:
 */
class MainPresenter(context: Context, mView: MainView, mModel: MainModel) :
    BasePresenter<MainView, MainModel>(context, mView, mModel) {

    fun getUserInfoService(params : ApiParams){
        mModel.getUserInfo(params).subscribe(object : ResponseSubscribe<LivestockBean>(){
            override fun onNext(t: LivestockBean) {
                mView.show(t)
            }
            override fun onError(e: Throwable) {

            }
        })
    }
}