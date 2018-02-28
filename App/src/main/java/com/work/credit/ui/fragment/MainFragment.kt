package com.work.credit.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.work.base.ui.fragment.BaseFragment
import com.work.base.widgets.BannerImageLoader

import com.work.credit.R
import com.work.credit.common.*
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNews()
    }

    /*
   初始化banner
    */
    private fun initBanner() {
        banner_home.setImageLoader(BannerImageLoader())
        banner_home.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO
                , HOME_BANNER_THREE, HOME_BANNER_FOUR))
        banner_home.setBannerAnimation(Transformer.Default);
        //设置轮播时间
        banner_home.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        banner_home.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner_home.start();
    }

    private fun initNews() {

        val info = arrayListOf<String>()
        info.add("1. 大家好，我是孙福生。")
        info.add("2. 欢迎大家关注我哦！")
        info.add("3. GitHub帐号：sfsheng0322")
        info.add("4. 新浪微博：孙福生微博")
        info.add("5. 个人博客：sunfusheng.com")
        info.add("6. 微信公众号：孙福生")
        mv_notice.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out)
    }

}// Required empty public constructor
