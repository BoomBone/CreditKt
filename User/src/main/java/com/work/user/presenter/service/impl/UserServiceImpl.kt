package com.work.user.presenter.service.impl

import com.work.user.presenter.service.UserService
import io.reactivex.Observable

/**
 * Created by Ting on 2018/1/5.
 */
class UserServiceImpl:UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}