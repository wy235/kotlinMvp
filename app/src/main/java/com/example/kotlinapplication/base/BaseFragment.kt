package com.example.kotlinapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle3.components.support.RxFragment

/**
 *作者:wangyu
 *创建时间:2019/11/25 14:13
 *描述:
 */
abstract class BaseFragment<P,M : BaseModel> : RxFragment(){

    var mPresenter: P ? = null
    var mModel: M ? = null
    var mRootView : View ? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(mRootView == null){
            mRootView = View.inflate(activity,getLayoutId(),container)
        }
        initModel()
        if(mModel != null){
            mModel!!.mRxFragment = this
        }
        setListener()
        processLogic()
        initView()
        initPresenter()
        return mRootView
    }

    abstract fun initView()

    abstract fun initModel()

    abstract fun initPresenter()

    abstract fun setListener()

    abstract fun processLogic()

    abstract fun getLayoutId() : Int
}