package com.work.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Created by Ting on 2018/1/23.
 * @function 用于管理App的Activity,入栈，出栈退出App
 */
class AppManager private constructor() {

    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    /**
     * Activity入栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * Activity出栈
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 获取当前栈顶
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 清理栈
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     * 使用的地方需要添加权限
     */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(
                Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}