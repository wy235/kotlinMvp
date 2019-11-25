package com.example.kotlinapplication.ui

import android.util.Log
import com.example.kotlinapplication.R
import com.example.kotlinapplication.base.BaseActivity
import com.example.kotlinapplication.net.utils.ApiParams
import com.example.kotlinapplication.ui.bean.LivestockBean
import com.example.kotlinapplication.ui.model.MainModel
import com.example.kotlinapplication.ui.presenter.MainPresenter
import com.example.kotlinapplication.ui.view.MainView

class MainActivity : BaseActivity<MainPresenter, MainModel>(),MainView{

    override fun show(item: LivestockBean) {
        Log.e("1111111111111111111",item.toString())
    }

    override fun initView() {

    }

    override fun initModel() {
        mModel = MainModel()
    }

    override fun initPresenter() {
        mPresenter = MainPresenter(this,this, (this!!.mModel)!!)
        val params = ApiParams()
        params.put("cattleId", "547")
        mPresenter!!.getUserInfoService(params)
    }

    override fun setListener() {
    }

    override fun processLogic() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}