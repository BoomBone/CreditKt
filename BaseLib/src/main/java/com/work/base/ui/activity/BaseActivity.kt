package com.work.base.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.work.base.common.AppManager

/**
 * Created by Ting on 2018/1/4.
 */
open class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}