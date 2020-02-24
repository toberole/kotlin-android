package com.zw.kotlin_android.demo1

import android.util.Log

open class Anim {
    companion object {
        var TAG = Anim::class.simpleName
    }

    var weight: Float = 0F

    open fun sys() {
        Log.i(TAG, "Anim weight: " + weight)
    }
}