package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil

class Main4Activity_Base_2 : AppCompatActivity() {
    val TAG: String = "Main4Activity_Base_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4__base_2)

        test1()
        test2()
    }

    private fun test1() {
        var a = 1
        var b = -2
        var c = true
        var d = false
        // 操作符实现
        LogUtil.i(TAG, "+a = ${+a}\t -a = ${-a}\t !c = ${!c}")
        LogUtil.i(TAG, "+b = ${+b}\t -b = ${-b}\t !d = ${!d}")

        // 操作符重载实现
        LogUtil.i(TAG, "+a = ${a.unaryPlus()}\t -a = ${a.unaryMinus()}\t !c = ${c.not()}")
        LogUtil.i(TAG, "+b = ${b.unaryPlus()}\t -b = ${b.unaryMinus()}\t !d = ${d.not()}")
    }

    /*
        a++	a.inc()	a = a.also{ a.inc() }
        a--	a.dec()	a = a.also{ a.dec() }
        ++a	a.inc()	a = a.inc().also{ a = it }
        --a	a.dec()	a = a.dec().also{ a = it }
     */
    private fun test2() {
        var a = 10
        var b = 10
        var c = 10
        var d = 10

        // 操作符实现
        LogUtil.i(TAG, "a++ = ${a++} \t b-- = ${b--} \t ++c = ${++c} \t --d = ${--d}")

        // 操作符重载方式实现
        a.also { a.inc() }
        b.also { b.dec() }
        // 后加 c++
        c.inc().also { c = it }
        // 后减 d--
        d.dec().also { d = it }
        LogUtil.i(TAG, "a = $a \t b = $b \t c = $c \t d = $d")
    }
}
