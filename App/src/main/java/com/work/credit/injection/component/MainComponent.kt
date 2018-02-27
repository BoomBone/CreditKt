package com.work.credit.injection.component

import com.work.base.injection.PerComponentScope
import com.work.base.injection.component.ActivityComponent
import com.work.credit.ui.activity.MainActivity
import dagger.Component

/**
 * Created by Ting on 2018/2/22.
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)])
interface MainComponent {
    fun inject(activity: MainActivity)
}
