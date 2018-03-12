package com.work.credit.injection.component

import com.dexin.creditkt.ui.fragment.MainFragment
import com.work.base.injection.PerComponentScope
import com.work.base.injection.component.ActivityComponent
import dagger.Component

/**
 * Created by Ting on 2018/2/22.
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)])
interface HomeComponent {
    fun inject(fragment: MainFragment)
}
