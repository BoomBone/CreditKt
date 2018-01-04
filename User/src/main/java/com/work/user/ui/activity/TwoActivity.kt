package com.work.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.work.user.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class TwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        verticalLayout {
            padding = 30
            editText {
                hint = "name"
                textSize = 24f
            }
            button{
                text = "text"
                onClick {
                    toast("点击")
                }
            }
        }
    }
}
