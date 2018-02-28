package com.work.base.common

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.work.base.injection.component.AppComponent
import com.work.base.injection.component.DaggerAppComponent
import com.work.base.injection.module.AppModule
import com.work.base.utils.log.DiLog

/**
 * Created by Ting on 2018/2/23.
 */
class BaseApplication : Application() {
    lateinit var appComponent: AppComponent
    private val openLog = true
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        initLog()
        context = this
    }

    private fun initLog() {
        if (openLog) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var context: Context
    }
}