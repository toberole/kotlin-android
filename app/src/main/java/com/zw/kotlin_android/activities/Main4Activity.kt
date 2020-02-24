package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R

class Main4Activity : AppCompatActivity() {

    // 只读属性可以使用适合放在一行上的较短语法。
    val defaultExtension: String get() = "kt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }
}
