package com.example.kotlinapplication.ui.view

import com.example.kotlinapplication.base.BaseView
import com.example.kotlinapplication.ui.bean.LivestockBean

/**
 *作者:wangyu
 *创建时间:2019/11/21 16:50
 *描述:
 */
interface MainView : BaseView{

    fun show(item : LivestockBean)
}