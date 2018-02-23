package com.work.base.injection.component

import android.app.Activity
import android.content.Context
import com.work.base.injection.ActivityScope
import com.work.base.injection.module.ActivityModule
import dagger.Component

/**
 * Created by Ting on 2018/2/23.
 */
@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
}