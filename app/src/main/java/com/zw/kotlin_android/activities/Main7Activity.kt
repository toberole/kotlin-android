package com.zw.kotlin_android.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main7.*

/*
    高阶函数：lambda作为函数的参数
 */
class Main7Activity : AppCompatActivity(), View.OnClickListener {
    fun test(a: Int, b: Int, m: (num1: Int, num2: Int) -> Int): Int {
        return m(a, b)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                btn_test1()
            }

            R.id.btn_test2 -> {
                btn_test2()
            }
        }
    }

    /*
        with、run
        使用对象可为null时，使用T.run()比使用with()函数从代码的可读性与简洁性来说要好一些。
     */
    fun btn_test2() {
        var str: String = "hello"
        with(str) {
            LogUtil.i("btn_test2-xxx", "with len = ${str.length}")
        }

        str.run {
            LogUtil.i("btn_test2-xxx", "run len = ${str.length}")
        }

        // apply
        tv_demo.apply {
            text = "** demo ** " + System.currentTimeMillis()
        }.apply {
            setTextColor(Color.GREEN)
        }

        ////////////////also、apply///////////////////////
        /*
            T.also中只能使用it调用自身,而T.apply中只能使用this调用自身。
            因为在源码中T.also是执行block(this)后在返回自身。
            而T.apply是执行block()后在返回自身。这就是为什么在一些函数中可以使用it,而一些函数中只能使用this的关键所在
         */
        "kotlin".also {
            println("结果：${it.plus("-java")}")
        }.also {
            println("结果：${it.plus("-php")}")
        }

        "kotlin".apply {
            println("结果：${this.plus("-java")}")
        }.apply {
            println("结果：${this.plus("-php")}")
        }

        // let 空安全
        "kotlin".let {
            println("原字符串：$it")         // kotlin
            it.reversed()
        }.let {
            println("反转字符串后的值：$it")     // niltok
            it.plus("-java")
        }.let {
            println("新的字符串：$it")          // niltok-java
        }

        // 判断一个字符串是否由某一个字符起始，若条件成立则返回自身，反之，则返回null
        val str_takeIf = "kotlin"
        val result = str_takeIf.takeIf {
            it.startsWith("ko")
        }

        // takeUnless()函数 传入一个你希望的一个条件，如果对象符合你的条件则返回null，反之，则返回自身。

        // repeat()重复相关的一个函数

        // lazy()用于延迟操作

    }

    fun btn_test1() {
        var ret = test(1, 2, { num1: Int, num2: Int ->
            LogUtil.i("Main7Activity-xxx", "调用高阶函数方法 1")
            num1 + num2
        })
        LogUtil.i("Main7Activity-xxx", "调用高阶函数方法 1 ret: $ret")

        // 注意区别第一种调用方法 参数传递
        ret = test(3, 4) { num1: Int, num2: Int ->
            LogUtil.i("Main7Activity-xxx", "调用高阶函数方法 2")
            num1 + num2
        }
        LogUtil.i("Main7Activity-xxx", "调用高阶函数方法 2 ret: $ret")
    }
}
