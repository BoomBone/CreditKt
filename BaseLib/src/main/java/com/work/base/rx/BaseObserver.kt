package com.work.base.rx

import com.work.base.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Ting on 2018/1/23.
 */
open class BaseObserver<T>(val baseView: BaseView) : Observer<T> {
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        if (e is BaseException) {
            baseView.onError(e.msg)
        }
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onComplete() {
        baseView.hideLoading()
    }
}