package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil

/*
       抽象类
       抽象类的规则
            在Kotlin中的抽象类在顶层定义的时候只能使用public可见性修饰符修饰。
            抽象类中可以定义内部抽象类。
            只能继承一个抽象类。
            若要实现抽象类的实例化，需要依靠子类采用向上转型的方式处理。
            抽象类可以继承自一个继承类，即抽象类可以作为子类。不过，抽象类建议不用open修饰符修饰，因为可以覆写抽象类的父类的函数。
 */

abstract class Abstract_Class {
    // 自身属性
    val TAG = this.javaClass.simpleName

    // 自身函数
    fun test() {
        LogUtil.i(TAG, "test ......")
    }

    // 抽象属性
    abstract var name: String

    // 抽象方法
    abstract fun test_abs()
}

class Abstract_Class_IMPL : Abstract_Class() {
    override var name: String = ""
        get() = "hello"
        set(value) {
            field = value
        }

    override fun test_abs() {

    }
}