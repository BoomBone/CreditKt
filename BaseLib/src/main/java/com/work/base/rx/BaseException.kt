package com.work.base.rx

/**
 * Created by Ting on 2018/1/24.
 * 定义通用异常
 */

class BaseException(val status:Int,val msg:String):Throwable() {
}