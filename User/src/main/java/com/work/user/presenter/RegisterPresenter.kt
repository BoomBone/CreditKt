package com.work.user.presenter

import android.util.Log
import com.work.base.ext.execute
import com.work.base.presenter.BasePresenter
import com.work.base.rx.BaseObserver
import com.work.user.presenter.service.impl.UserServiceImpl
import com.work.user.presenter.view.RegisterView
import javax.inject.Inject

/**
 * Created by Ting on 2018/1/4.
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         * 可以直接网络请求了
         */
        if (!checkNetWork()){
            //网络不可用
            return
        }

        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        Log.e("main", "onNext")
                    }
                })

        mView.onRegisterResult(true)
    }
}