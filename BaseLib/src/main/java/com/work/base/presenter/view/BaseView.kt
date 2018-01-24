package com.work.base.presenter.view

/**
 * Created by Ting on 2018/1/4.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}