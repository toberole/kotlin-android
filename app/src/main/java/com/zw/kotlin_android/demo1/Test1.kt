package com.zw.kotlin_android.demo1

/**
 * 类构造相关
 */
class Test1 constructor(code: Int, msg: String, age: Int) {
    private var code: Int = 0
    private var msg: String
    // 写法
    private var age: Int = age

    private var cb: MyInterface? = null
    private var cb1: ((Int, String) -> Unit)? = null

    init {
        this.code = code
        this.msg = msg
    }

    fun setCB(cb: MyInterface) {
        this.cb = cb
    }

    fun setCB1(cb: (Int, String) -> Unit) {
        this.cb1 = cb
    }

    fun test() {
        cb?.callback(code, msg)
    }

    fun test1() {
        this.cb1?.invoke(code, msg)
    }
}