package com.work.base.rx.rxnet


import com.work.base.common.BaseConstance
import com.work.ddnet.rx.RxRestService

import java.util.WeakHashMap
import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author Ting
 * @date 2017/11/15
 */

object RestCreator {

    fun getParam() = ParamsHolder.PARAMS
    fun getRxService() = RxServiceHolder.REST_SERVICE

    /**
     * 参数容器
     */
    private object ParamsHolder {
        val PARAMS = WeakHashMap<String, Any>()
    }

    /**
     * 构建全局Retrofit客户端
     */
    private object RetrofitHolder {
        private val BASE_URL = BaseConstance.SERVER_ADDRESS
        val RETROFIT_CLIENT = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHolder.OKHTTP_CLIENT)
                .build()
    }

    /**
     * 构建OkHttp
     */
    private object OkHttpHolder {
        private val TIME_OUT = 60
        private val BUILDER = OkHttpClient.Builder()

        val OKHTTP_CLIENT = BUILDER
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .build()
    }

    /**
     * RxService接口
     */
    private object RxServiceHolder {
        val REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RxRestService::class.java)
    }


}
