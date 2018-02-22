package com.work.base.presenter

import android.content.Context
import com.work.base.presenter.view.BaseView
import com.work.base.utils.NetWorkUtils
import javax.inject.Inject

/**
 * Created by Ting on 2018/1/4.
 * 基本的业务处理层，需要的页面接口
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var context:Context

    fun checkNetWork():Boolean{
        return NetWorkUtils.isNetWorkAvailable(context)
    }
}