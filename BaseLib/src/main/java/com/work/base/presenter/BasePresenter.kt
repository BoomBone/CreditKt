package com.work.base.presenter

import com.work.base.presenter.view.BaseView

/**
 * Created by Ting on 2018/1/4.
 * 基本的业务处理层，需要的页面接口
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}