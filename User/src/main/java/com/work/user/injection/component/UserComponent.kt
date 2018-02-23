package com.work.user.injection.component

import com.work.base.injection.PerComponentScope
import com.work.base.injection.component.ActivityComponent
import com.work.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by Ting on 2018/2/22.
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}