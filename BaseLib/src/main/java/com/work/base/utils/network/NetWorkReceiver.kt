package com.work.base.utils.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log


import java.util.ArrayList


/**
 * Created by Jin on 2017/6/27.
 */
class NetWorkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        receive = this@NetWorkReceiver
        if (intent.action!!.equals(ANDROID_NET_CHANGE_ACTION, ignoreCase = true) || intent.action!!.equals(OS_ANDROID_NET_CHANGE_ACTION, ignoreCase = true)) {
            if (!NetWorkUtil.isNetworkAvailable(context)) {
                isNetworkAvailable = false
            } else {
                apnType = NetWorkUtil.getAPNType(context)
                isNetworkAvailable = true
            }
            notifyObserver()
        }
    }

    private fun notifyObserver() {
        for (i in netChangeObserverArrayList!!.indices) {
            val observer = netChangeObserverArrayList!![i]
            if (observer != null) {
                if (isNetworkAvailable!!) {
                    observer.onNetConnect(apnType!!)
                } else {
                    observer.onNetDisconnect()
                }
            }
        }
    }

    companion object {
        /**
         * 获取当前网络状态，true为网络连接成功，否则网络连接失败
         *
         * @return
         */
        var isNetworkAvailable: Boolean? = false
            private set
        var apnType: NetWorkUtil.NetType? = null
            private set
        private var netChangeObserverArrayList: ArrayList<NetChangeObserver>? = ArrayList()
        private val ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
        val OS_ANDROID_NET_CHANGE_ACTION = "os.android.net.conn.CONNECTIVITY_CHANGE"
        private var receive: BroadcastReceiver? = null

        private val receiver: BroadcastReceiver
            get() {
                if (receive == null) {
                    receive = NetWorkReceiver()
                }
                return receive as BroadcastReceiver
            }

        /**
         * 注册网络状态广播
         *
         * @param mContext
         */
        fun registerNetworkStateReceiver(mContext: Context) {
            val filter = IntentFilter()
            filter.addAction(OS_ANDROID_NET_CHANGE_ACTION)
            filter.addAction(ANDROID_NET_CHANGE_ACTION)
            mContext.applicationContext.registerReceiver(receiver, filter)
        }

        /**
         * 检查网络状态
         *
         * @param mContext
         */
        fun checkNetworkState(mContext: Context) {

            val intent = Intent()
            intent.action = OS_ANDROID_NET_CHANGE_ACTION
            mContext.sendBroadcast(intent)
        }

        /**
         * 注销网络状态广播
         *
         * @param mContext
         */
        fun unRegisterNetworkStateReceiver(mContext: Context) {
            if (receive != null) {
                try {
                    mContext.applicationContext.unregisterReceiver(receive)
                } catch (e: Exception) {
                    Log.d(NetWorkReceiver::class.java.name, e.message)
                }

            }

        }

        /**
         * 注册网络连接观察者
         *
         * @param observer 观察者实例
         */
        fun registerObserver(observer: NetChangeObserver) {
            if (netChangeObserverArrayList == null) {
                netChangeObserverArrayList = ArrayList()
            }
            netChangeObserverArrayList!!.add(observer)
        }

        /**
         * 注销网络连接观察者
         *
         * @param observer 观察者实例
         */
        fun removeRegisterObserver(observer: NetChangeObserver) {
            if (netChangeObserverArrayList != null) {
                netChangeObserverArrayList!!.remove(observer)
            }
        }
    }

}