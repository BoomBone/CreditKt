package com.work.user.presenter

import com.work.base.presenter.BasePresenter
import com.work.user.presenter.view.RegisterView

/**
 * Created by Ting on 2018/1/4.
 */
class RegisterPresenter: BasePresenter<RegisterView>() {
    fun register(mobile:String,verifyCode:String){
        /**
         * 业务逻辑
         */
        mView.onRegisterResult(true)
    }
}