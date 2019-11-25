package com.example.kotlinapplication.net

import android.util.Log
import com.example.kotlinapplication.KotlinApplication
import com.example.kotlinapplication.net.factory.CustomConverterFactory
import com.example.kotlinapplication.net.utils.NetUtils
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *作者:wangyu
 *创建时间:2019/11/21 13:23
 *描述:网络请求
 */
class NetRetrofitApi {

    val TAG : String = "KotlinBase"
    val BASE_URL : String = "http://39.108.79.180:8088"
    private val CACHE_NAME : String = "KotlinDemo"
    private val DEFAULT_CONNECT_TIMEOUT : Int = 30
    private val DEFAULT_WRITE_TIMEOUT : Int = 30
    private val DEFAULT_READ_TIMEOUT : Int = 30
    private var retrofit : Retrofit ? = null
    private var okHttpBuilder : OkHttpClient.Builder ? = null

    init {
        okHttpBuilder = OkHttpClient.Builder()
        var cacheFile = File(KotlinApplication.getContext()!!.externalCacheDir, CACHE_NAME)
        var cache = Cache(cacheFile, 1024 * 1024 * 50)
        var catchInterceptor = Interceptor{ chain ->
            var request = chain.request()
            if(!NetUtils.isNetworkConnected()){
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
            }
            val response = chain.proceed(request)
            if(!NetUtils.isNetworkConnected()) run {
                var maxAge = 0
                response.newBuilder().header("Cache-Control", "public, max-age=$maxAge")
                    .build()
            }else{
                var maxStale = 60 * 60 * 24 * 28
                response.newBuilder().header("Cache-Control","public, only-if-cached, max-stale=$maxStale")
                    .removeHeader(CACHE_NAME)
                    .build()
            }
            response
        }
        okHttpBuilder!!.cache(cache).addInterceptor(catchInterceptor)

        var headerInterceptor = Interceptor{ chain ->
            var request = chain.request()
            var builder = request.newBuilder()
            builder = NetUtils.getNetHeader(builder).method(request.method(),request.body())
            builder.addHeader("_Token_",NetUtils.TOKEN)
            var secRequest = builder.build()
            chain.proceed(secRequest)
        }
        okHttpBuilder!!.addInterceptor(headerInterceptor)

        var loggingInterceptor = HttpLoggingInterceptor{
            Log.e("HttpLoggingInterceptor", it)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        //!!: 表示当前对象不为空的情况下执行
        okHttpBuilder!!.addInterceptor(loggingInterceptor)

        okHttpBuilder!!.connectTimeout(DEFAULT_CONNECT_TIMEOUT.toLong(),TimeUnit.SECONDS)
        okHttpBuilder!!.readTimeout(DEFAULT_READ_TIMEOUT.toLong(),TimeUnit.SECONDS)
        okHttpBuilder!!.writeTimeout(DEFAULT_WRITE_TIMEOUT.toLong(),TimeUnit.SECONDS)

        okHttpBuilder!!.retryOnConnectionFailure(true)
        retrofit = Retrofit.Builder()
            .client(okHttpBuilder!!.build())
            .addConverterFactory(CustomConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    //在访问HttpMethods时创建单例
    private object SingletonHolder {
        val INSTANCE = NetRetrofitApi()
    }

    //获取单例
    fun getInstance(): NetRetrofitApi {
        return SingletonHolder.INSTANCE
    }

    fun getRetrofit() : Retrofit? {
        if(retrofit == null){
            return null
        }
        return retrofit as Retrofit
    }

    fun <T> getProxy(t: Class<T>): T {
        return getRetrofit()!!.create(t)
    }
}