package com.work.user.presenter

import android.util.Log
import com.work.base.ext.execute
import com.work.base.presenter.BasePresenter
import com.work.base.rx.BaseObserver
import com.work.user.presenter.service.impl.UserServiceImpl
import com.work.user.presenter.view.RegisterView

/**
 * Created by Ting on 2018/1/4.
 * @function Presenter层用于处理业务逻辑
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String, pwd: String, view: RegisterView) {
        /**
         * 业务逻辑
         * 可以直接网络请求了
         */
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseObserver<Boolean>(view) {
                    override fun onNext(t: Boolean) {
                        Log.e("main", "onNext")
                    }
                })

        mView.onRegisterResult(true)
    }
}