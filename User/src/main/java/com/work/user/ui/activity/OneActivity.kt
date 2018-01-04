package com.work.user.ui.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.work.user.R
import kotlinx.android.synthetic.main.activity_one.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class OneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        btn.setOnClickListener{
            startActivity<TwoActivity>()
        }
    }
}
