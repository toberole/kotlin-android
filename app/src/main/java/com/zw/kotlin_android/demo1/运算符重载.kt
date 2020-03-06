package com.zw.kotlin_android.demo1

/*
    运算符重载
 */
class Demo_x(var i: Int) {
    operator fun plus(demox: Demo_x): Demo_x {
        this.i = this.i + demox.i
        return this
    }
}

