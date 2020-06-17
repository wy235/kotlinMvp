package com.example.kotlinapplication.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlinapplication.R
import com.example.kotlinapplication.base.BaseActivity
import com.example.kotlinapplication.net.utils.ApiParams
import com.example.kotlinapplication.ui.bean.LivestockBean
import com.example.kotlinapplication.ui.model.MainModel
import com.example.kotlinapplication.ui.presenter.MainPresenter
import com.example.kotlinapplication.ui.view.MainView
import icepick.State
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : BaseActivity<MainPresenter, MainModel>(),MainView{

    @State
    var list = listOf<Integer>()
    @State
    var map = hashMapOf<Integer,String>()

    override fun show(item: LivestockBean) {
        Log.e("1111111111111111111",item.toString())
    }

    override fun initView() {
        mImage.setOnClickListener {
            Toast.makeText(this,singletonList("Hello world").toString(),Toast.LENGTH_LONG).show()
        }
    }

    private fun getStrValue(ins : Int) : String{
        return ins.toString();
    }

    private fun double(xx:Int) = xx

    //类型转换
    fun <T> singletonList(item : T) : MutableList<Any> {
        var  arr = mutableListOf<Any>()
        for (index in 0..5){
            if(item is Int){
                arr.add(index,item * index)
            }else{
                var str : String? = item as? String
                arr.add(index,str + index)
            }
        }
        return arr
    }

    override fun initModel() {
        mModel = MainModel()
    }

    override fun initPresenter() {
        mPresenter = MainPresenter(this,this, (this.mModel)!!)
        val params = ApiParams()
        params["cattleId"] = "547"
        mPresenter!!.getUserInfoService(params)
    }

    override fun setListener() {
        var number = Random.nextInt(42)
    }

    override fun processLogic() {
        //Dispatchers.Main 会报错   使用Dispatchers.Unconfined 没问题 主线程
        GlobalScope.launch(Dispatchers.Unconfined){
            Log.e("CurrentyThread1",Thread.currentThread().name)
            val bm = getImageResource()
            mImage.setImageResource(bm)
        }

        CoroutineScope(Dispatchers.Unconfined).async {
            Log.e("CurrentyThread5",Thread.currentThread().name)
            val bm: Deferred<Int>  = async{
                Log.e("CurrentyThread4",Thread.currentThread().name)
                getImageResource()
            }
            mImage.setImageResource(bm.await())
        }

        /*CoroutineScope(Dispatchers.Unconfined).launch {
            Log.e("CurrentyThread3",Thread.currentThread().name)
            val bm = getImageResource()
            mImage.setImageResource(bm)
        }*/
    }

    suspend fun getImageResource() : Int  = withContext(Dispatchers.IO){
        Log.e("CurrentyThread2",Thread.currentThread().name)
        withContext@ R.mipmap.ic_launcher
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    fun printSum(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }

    fun getStringLength(obj : Any) : Int? {
        if (obj !is String) return null
        return obj.length
    }

    /*创建单例*/
    object Resource {
        val name = "Name"
    }

}
