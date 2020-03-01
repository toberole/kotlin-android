package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil

class Extend_Class(var str: String) {
    var TAG = Extend_Class::class.simpleName

    fun p() {
        LogUtil.i(TAG + "", "str = $str")
    }
}