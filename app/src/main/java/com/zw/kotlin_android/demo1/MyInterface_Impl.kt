package com.zw.kotlin_android.demo1

import android.util.Log

class MyInterface_Impl : MyInterface {
    companion object {
        var TAG: String = MyInterface_Impl::class.java.simpleName
    }

    override fun callback(errorCode: Int, errorMsg: String) {
        Log.i(TAG, "errorCode: " + errorCode + ",errorMsg: " + errorMsg)
    }
}