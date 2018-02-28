package com.work.base.utils.log

import com.orhanobut.logger.Logger

/**
 * @author Ting
 * @date 2017/12/2.
 */

object DiLog {

    private val VERBOSE = 1
    private val DEBUG = 2
    private val INFO = 3
    private val WARN = 4
    private val ERROR = 5
    private val CLOSE = 6

    //控制log等级
    private val LEVEL = VERBOSE

    fun v(tag: String, message: String) {
        if (LEVEL <= VERBOSE) {
            Logger.t(tag).v(message)
        }
    }

    fun d(tag: String, message: Any) {
        if (LEVEL <= DEBUG) {
            Logger.t(tag).d(message)
        }
    }

    fun d(message: Any) {
        if (LEVEL <= DEBUG) {
            Logger.d(message)
        }
    }

    fun i(tag: String, message: String) {
        if (LEVEL <= INFO) {
            Logger.t(tag).i(message)
        }
    }

    fun w(tag: String, message: String) {
        if (LEVEL <= WARN) {
            Logger.t(tag).w(message)
        }
    }

    fun json(tag: String, message: String) {
        if (LEVEL <= WARN) {
            Logger.t(tag).json(message)
        }
    }

    fun e(tag: String, message: String) {
        if (LEVEL <= ERROR) {
            Logger.t(tag).e(message)
        }
    }
}