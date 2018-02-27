package com.work.credit.present

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import com.work.base.presenter.BasePresenter
import com.work.base.view.CustomScrollViewPager
import com.work.credit.present.view.MainView
import com.work.credit.ui.adapter.ViewPagerAdapter
import com.work.credit.ui.fragment.LoanFragment
import com.work.credit.ui.fragment.MainFragment
import com.work.credit.ui.fragment.PersonalFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/*
 Created by Ting on 2018/2/27.
*/
class MainPresent @Inject constructor() : BasePresenter<MainView>() {
    /**
     * 设置viewpager
     */
    fun setupViewPager(viewPager: CustomScrollViewPager, context: Context
                       , fm: FragmentManager, status: Int, tabs: TabLayout) {
        val adapter = ViewPagerAdapter(fm, context)
        adapter.addFragment(MainFragment())
        adapter.addFragment(LoanFragment())
        adapter.addFragment(PersonalFragment())
        viewPager.adapter = adapter
        if (status == 1) {
            viewPager.currentItem = 2
        } else {
            viewPager.currentItem = 1
        }
        tabs.setupWithViewPager(viewPager)
        for (i in 0 until tabs.tabCount) {
            val tab = tabs.getTabAt(i)
            tab!!.customView = adapter.getTabView(i)
        }
    }
}