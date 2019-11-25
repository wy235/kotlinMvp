package com.example.kotlinapplication.net.api

import com.example.kotlinapplication.net.utils.ApiParams
import com.example.kotlinapplication.ui.bean.LivestockBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

/**
 *作者:wangyu
 *创建时间:2019/11/25 10:30
 *描述:
 */
interface UserApi {

    @FormUrlEncoded
    @POST
    fun getUserInfoService(@Url url: String, @FieldMap params: ApiParams): Observable<LivestockBean>
}