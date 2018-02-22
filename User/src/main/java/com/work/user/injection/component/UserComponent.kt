package com.work.user.injection.component

import com.work.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by Ting on 2018/2/22.
 */
@Component
interface UserComponent {
    fun inject(activity: RegisterActivity)
}