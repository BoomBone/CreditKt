package com.work.base.ui.activity

import android.os.Bundle
import com.work.base.common.BaseApplication
import com.work.base.injection.component.ActivityComponent
import com.work.base.injection.component.DaggerActivityComponent
import com.work.base.injection.module.ActivityModule
import com.work.base.presenter.BasePresenter
import com.work.base.presenter.view.BaseView
import com.work.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Ting on 2018/1/4.
 */
abstract open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    private lateinit var mLoadingDialog: ProgressLoading

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
        //初始化加载框
        mLoadingDialog = ProgressLoading.create(this)
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T

}