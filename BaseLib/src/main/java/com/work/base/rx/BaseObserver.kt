package com.work.base.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Ting on 2018/1/23.
 */
open class BaseObserver<T> :Observer<T> {
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onComplete() {
    }
}