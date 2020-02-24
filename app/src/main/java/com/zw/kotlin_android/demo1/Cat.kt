package com.zw.kotlin_android.demo1

import android.util.Log

class Cat : Anim() {
    override fun sys() {
        super.sys()
        Log.i("Cat", "cat ......")
    }
}