package com.work.user.presenter.service

import io.reactivex.Observable


/**
 * Created by Ting on 2018/1/5.
 */
interface UserService {
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>
}