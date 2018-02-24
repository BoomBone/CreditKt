package com.work.credit.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.work.base.widgets.BannerImageLoader

import com.work.credit.R
import com.work.credit.common.*
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
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

}// Required empty public constructor
