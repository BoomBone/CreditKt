package com.work.base.ext

import com.work.base.rx.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ting on 2018/1/23.
 * @function 简化。execute 代替 .observeOn .subscribeOn .subscribe
 */

fun <T> Observable<T> .execute(observer: BaseObserver<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(observer)
}