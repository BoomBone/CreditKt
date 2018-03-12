package com.work.credit.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.work.base.injection.component.DaggerAppComponent
import com.work.base.ui.activity.BaseMvpActivity
import com.work.base.utils.network.NetChangeObserver
import com.work.base.utils.network.NetWorkReceiver
import com.work.base.utils.network.NetWorkUtil
import com.work.base.view.CustomScrollViewPager
import com.work.credit.R
import com.work.credit.injection.component.DaggerMainComponent
import com.work.credit.present.MainPresent
import com.work.credit.present.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.network_error_layout.*

class MainActivity : BaseMvpActivity<MainPresent>(), MainView, NetChangeObserver {

    private var status = 0
    private lateinit var viewPager: CustomScrollViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder()
                .activityComponent(activityComponent)
                .build()
                .inject(this)
        NetWorkReceiver.registerObserver(this)
        NetWorkReceiver.registerNetworkStateReceiver(this)
        val viewPager = main_activity_viewpager
        mPresenter.mView = this
        mPresenter.setupViewPager(viewPager, this, supportFragmentManager, status, main_activity_tabs)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        status = 1
        viewPager.currentItem = 2
    }

    override fun onDestroy() {
        super.onDestroy()
        NetWorkReceiver.unRegisterNetworkStateReceiver(this)
    }

    override fun onNetConnect(type: NetWorkUtil.NetType) {
        net_status_bar_top.visibility = View.GONE
    }

    override fun onNetDisconnect() {
        net_status_bar_top.visibility = View.VISIBLE
    }
}
