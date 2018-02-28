package com.work.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.work.base.R

/**
 * Created by Ting on 2018/2/23.
 */
/*
    Glide工具类
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        GlideApp.with(context).load(url).centerCrop().into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        GlideApp.with(context).load(url).fitCenter().into(imageView)
    }
}