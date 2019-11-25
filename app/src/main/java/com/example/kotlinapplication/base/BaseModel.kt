package com.example.kotlinapplication.base

import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.android.FragmentEvent
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.trello.rxlifecycle3.components.support.RxFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *作者:wangyu
 *创建时间:2019/11/21 10:24
 *描述:
 */
abstract class BaseModel{

    var mRxActivity: RxAppCompatActivity? = null
    var mRxFragment: RxFragment? = null
    var RETRY_COUNT : Long = 1

    /**
     * Activity Rx 公共
     */
    fun <T> initActivityObservable(observable: Observable<T>) : Observable<T>{
        return observable.unsubscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.newThread())
            .retry(RETRY_COUNT)//请求失败重连次数
            .observeOn(AndroidSchedulers.mainThread())
            .compose(mRxActivity!!.bindUntilEvent(ActivityEvent.DESTROY))
    }

    /**
     * Fragment Rx 公共
     */
    fun <T> initFragmentObservable(observable: Observable<T>) : Observable<T>{
        return observable.unsubscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.newThread())
            .retry(RETRY_COUNT)//请求失败重连次数
            .observeOn(AndroidSchedulers.mainThread())
            .compose(mRxFragment!!.bindUntilEvent(FragmentEvent.DESTROY))
    }
}