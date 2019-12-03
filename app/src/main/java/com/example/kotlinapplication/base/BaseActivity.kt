package com.example.kotlinapplication.base
import android.os.Bundle
import android.os.PersistableBundle
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import icepick.Icepick

/**
 *作者:wangyu
 *创建时间:2019/11/21 10:52
 *描述:
 */
abstract class BaseActivity<P,M : BaseModel>: RxAppCompatActivity() {

    var mPresenter: P ? = null
    var mModel: M ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Icepick.restoreInstanceState(this,savedInstanceState)
        setContentView(getLayoutId())
        initModel()
        if(mModel != null){
            mModel!!.mRxActivity = this
        }
        setListener()
        initView()
        processLogic()
        initPresenter()
    }

    abstract fun initView()

    abstract fun initModel()

    abstract fun initPresenter()

    abstract fun setListener()

    abstract fun processLogic()

    abstract fun getLayoutId() : Int

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Icepick.saveInstanceState(this, outState)
    }
}