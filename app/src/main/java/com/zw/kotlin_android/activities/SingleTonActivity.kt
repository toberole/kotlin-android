package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.SingleTon_Demo
import com.zw.kotlin_android.demo1.SingleTon_Demo1

class SingleTonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_ton)
    }

    fun test() {
        SingleTon_Demo.test()
        SingleTon_Demo1.get().test()
    }
}
