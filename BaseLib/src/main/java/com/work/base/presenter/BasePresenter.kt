package com.work.base.presenter

import com.work.base.presenter.view.BaseView

/**
 * Created by Ting on 2018/1/4.
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}