package com.work.credit.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import com.work.credit.R
import kotlinx.android.synthetic.main.custom_tabview.view.*

/**
 * Created by Ting on 2018/2/26.
 */
class ViewPagerAdapter(fm: FragmentManager?, context: Context) : FragmentPagerAdapter(fm) {
    val mFragmentList = arrayListOf<Fragment>()
    val mContext =context
    val tabIcons = arrayOf(R.drawable.main_tab_home_select
            , R.drawable.main_tab_find_select
            , R.drawable.main_tab_mine_select)
    val titles = arrayOf("首页", "我要贷款", "个人中心")
    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }

    fun addFragment(fragment: android.support.v4.app.Fragment) {
        mFragmentList.add(fragment)
    }

    fun getTabView(position: Int): View {
        val v = LayoutInflater.from(mContext).inflate(R.layout.custom_tabview, null)
        v.tab_imageview.setImageResource(tabIcons[position])
        v.tab_textview.text = titles[position]
        if (position == 0) {
            v.setSelected(true)
        }
        return v
    }


}