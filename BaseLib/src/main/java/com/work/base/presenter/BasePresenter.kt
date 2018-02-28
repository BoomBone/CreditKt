package com.work.base.presenter

import android.content.Context
import com.work.base.presenter.view.BaseView
import com.work.base.utils.network.NetWorkUtil
import javax.inject.Inject

/**
 * Created by Ting on 2018/1/4.
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtil.isNetworkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}