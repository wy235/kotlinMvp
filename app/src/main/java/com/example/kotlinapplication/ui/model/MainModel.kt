package com.example.kotlinapplication.ui.model

import com.example.kotlinapplication.base.BaseModel
import com.example.kotlinapplication.net.NetRetrofitApi
import com.example.kotlinapplication.net.api.BaseApi
import com.example.kotlinapplication.net.api.UserApi
import com.example.kotlinapplication.net.utils.ApiParams
import com.example.kotlinapplication.ui.bean.LivestockBean
import io.reactivex.Observable

/**
 *作者:wangyu
 *创建时间:2019/11/21 16:50
 *描述:
 */
class MainModel : BaseModel() {

     fun getUserInfo(params : ApiParams): Observable<LivestockBean> {
        return initActivityObservable(NetRetrofitApi()
                .getInstance()
                .getProxy(UserApi::class.java)
                .getUserInfoService(BaseApi.CATTLE_DETEAL_URL, params))
    }
}