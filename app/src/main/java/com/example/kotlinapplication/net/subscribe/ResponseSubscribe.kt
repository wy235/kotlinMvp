package com.example.kotlinapplication.net.subscribe

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *作者:wangyu
 *创建时间:2019/11/25 10:48
 *描述:
 */
open class ResponseSubscribe<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }
}