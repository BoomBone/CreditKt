package com.work.base.injection.component

import android.content.Context
import com.work.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ting on 2018/2/23.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context(): Context
}