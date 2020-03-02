package com.zw.kotlin_android.demo1

// 委托

interface Base {
    fun print()
}

internal class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

// 第一种写法
internal class Derived(b: Base) : Base by b

// 第二种写法
internal class Derived1() : Base by test1()

fun test1(): Base {
    return object : Base {
        override fun print() {

        }
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}

