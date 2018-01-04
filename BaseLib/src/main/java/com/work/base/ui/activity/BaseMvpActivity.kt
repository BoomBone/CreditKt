package com.work.base.ui.activity

import com.work.base.presenter.BasePresenter
import com.work.base.presenter.view.BaseView

/**
 * Created by Ting on 2018/1/4.
 */
open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(),BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    lateinit var mPresenter:T
}