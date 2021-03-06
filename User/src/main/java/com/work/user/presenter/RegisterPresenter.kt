package com.work.user.presenter

import android.util.Log
import com.work.base.ext.execute
import com.work.base.presenter.BasePresenter
import com.work.base.rx.BaseObserver
import com.work.user.presenter.service.UserService
import com.work.user.presenter.view.RegisterView
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Ting on 2018/1/4.
 * @function Presenter层用于处理业务逻辑
 */
class RegisterPresenter : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         * 可以直接网络请求了
         */
        if (!checkNetWork()) {
            println("网络不可用")
            return
        }
        mView.showLoading()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        Log.e("main", "onNext")
                        mView.hideLoading()
                    }
                })

        mView.onRegisterResult(true)
    }
}