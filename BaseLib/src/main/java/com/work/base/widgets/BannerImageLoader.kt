package com.work.base.widgets

import android.content.Context
import android.widget.ImageView
import com.work.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * Created by Ting on 2018/2/24.
 * banner图片加载器
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadImage(context, path.toString(), imageView)
    }
}