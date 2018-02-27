package com.work.base.utils.network

/**
 * Created by Jin on 2017/6/27.
 */

/**
 * 是检测网络改变的观察者
 */
interface NetChangeObserver {
    /**
     * 网络连接连接时调用
     */
    fun onNetConnect(type: NetWorkUtil.NetType)

    /**
     * 当前没有网络连接
     */
    fun onNetDisconnect()
}
