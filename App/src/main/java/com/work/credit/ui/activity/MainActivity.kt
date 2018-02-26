package com.work.credit.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.work.base.view.CustomScrollViewPager
import com.work.credit.R
import com.work.credit.ui.adapter.ViewPagerAdapter
import com.work.credit.ui.fragment.LoanFragment
import com.work.credit.ui.fragment.MainFragment
import com.work.credit.ui.fragment.PersonalFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var status = 0
    private lateinit var viewPager: CustomScrollViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = main_activity_viewpager
        setupViewPager(viewPager)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        status = 1
        viewPager.currentItem = 2
    }

    private fun setupViewPager(viewPager: CustomScrollViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager, this)
        adapter.addFragment(MainFragment())
        adapter.addFragment(LoanFragment())
        adapter.addFragment(PersonalFragment())
        viewPager.adapter = adapter
        if (status == 1) {
            viewPager.currentItem = 2
        } else {
            viewPager.currentItem = 1
        }
        main_activity_tabs.setupWithViewPager(viewPager)
        for (i in 0 until main_activity_tabs.tabCount) {
            val tab = main_activity_tabs.getTabAt(i)
            tab!!.customView = adapter.getTabView(i)
        }
    }
}
