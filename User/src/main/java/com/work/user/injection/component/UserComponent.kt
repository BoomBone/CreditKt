package com.work.user.injection.component

import com.work.user.injection.module.UserModule
import com.work.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by Ting on 2018/2/22.
 * @function 用户模块Component
 */
@Component(modules = [(UserModule::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}