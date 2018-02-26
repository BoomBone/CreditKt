package com.work.base.view

import android.content.Context
import android.content.res.TypedArray
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

import com.work.base.R


/**
 * 自定义滚动禁用的ViewPager子类
 */
class CustomScrollViewPager : ViewPager {

    private var defaultPageSwipeable = false

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomScrollViewPager)
        defaultPageSwipeable = a.getBoolean(R.styleable.CustomScrollViewPager_scrolled, false)
        a.recycle()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.defaultPageSwipeable && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.defaultPageSwipeable && super.onInterceptTouchEvent(event)
    }

    fun setPageSwipeable(defaultPageSwipeable: Boolean) {
        this.defaultPageSwipeable = defaultPageSwipeable
    }
}