package com.work.user.ui.activity

import android.os.Bundle
import com.work.base.ui.activity.BaseMvpActivity
import com.work.user.R
import com.work.user.presenter.RegisterPresenter
import com.work.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initInjection()

        btn_register.setOnClickListener {
            mPresenter.register("", "", "")
        }
    }

    private fun initInjection() {
        mPresenter =RegisterPresenter()
        mPresenter.mView = this
    }
}
