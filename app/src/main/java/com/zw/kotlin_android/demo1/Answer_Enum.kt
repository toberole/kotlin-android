package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil

enum class Answer_Enum {
    YES, NO, MAYBE
}

enum class Enum1(a: Int) {
    E1(1), E2(2),
    E3(3) {
        override fun toString(): String {
            return super.toString()
        }
    }
}

fun test() {
    var e: Enum1 = Enum1.E1
    LogUtil.i("e-xxx", e.toString())
}