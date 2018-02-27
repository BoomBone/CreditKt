package com.work.base.common

import android.app.Application
import android.content.Context
import com.work.base.injection.component.AppComponent
import com.work.base.injection.component.DaggerAppComponent
import com.work.base.injection.module.AppModule

/**
* Created by Ting on 2018/2/23.
*/
class BaseApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context = this
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