package com.work.base.injection

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import java.lang.annotation.Retention

/**
 * Created by Ting on 2018/2/23.
 */
/*
    Activity级别 作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope