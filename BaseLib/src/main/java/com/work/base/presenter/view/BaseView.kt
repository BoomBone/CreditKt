package com.work.base.presenter.view

/**
 * Created by Ting on 2018/1/4.
 * @function 用于展示加载等基本页面
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}