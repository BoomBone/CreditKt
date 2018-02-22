package com.work.base.ui.activity

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化加载框
        mLoadingDialog = ProgressLoading.create(this)
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

    //Presenter泛型，Dagger注入
    lateinit var mPresenter: T
}