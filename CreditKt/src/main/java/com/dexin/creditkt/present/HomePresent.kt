package com.dexin.creditkt.present

import android.util.Log
import com.work.base.presenter.BasePresenter
import com.work.credit.present.view.HomeView
import javax.inject.Inject

/*
 Created by Ting on 2018/2/27.
*/
class HomePresent @Inject constructor() : BasePresenter<HomeView>() {
    fun println() {
        Log.e("main", "home")
    }
}