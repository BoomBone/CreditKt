package com.work.user.presenter

import android.util.Log
import com.work.base.presenter.BasePresenter
import com.work.user.presenter.service.impl.UserServiceImpl
import com.work.user.presenter.view.RegisterView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ting on 2018/1/4.
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object :Observer<Boolean>{
                    override fun onNext(t: Boolean) {
                        Log.e("main","onNext")
                    }

                    override fun onComplete() {
                        Log.e("main","onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.e("main","onSubscribe")
                    }

                    override fun onError(e: Throwable) {
                        Log.e("main","onError")
                    }
                })

        mView.onRegisterResult(true)
    }
}