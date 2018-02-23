package com.work.base.injection.module

import android.app.Activity
import com.work.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Ting on 2018/2/23.
 * Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return this.activity
    }
}