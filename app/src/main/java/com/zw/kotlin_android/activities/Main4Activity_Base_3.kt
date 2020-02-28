package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.Enum1
import com.zw.kotlin_android.utils.LogUtil

class Main4Activity_Base_3 : AppCompatActivity() {

    var TAG: String = "Main4Activity_Base_3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4__base_3)

        var e = Enum1.E1
        LogUtil.i("e-xxx", "name = ${e.name},ordinal = ${e.ordinal}")

        test2()
    }

    private fun test() {
        // 定义一个不可为空的变量，用var修饰的变量可以被重新赋值，用val修饰的变量则不能，但是不能赋值为null
        var a: Int = 12
        val b: Int = 13

        a = 20
        // a = null 不能复制为null
        // b = 20   不能被重新赋值

        if (a == null) {
            // 这样的判断毫无意义，因为变量a永远不可能null
        }

        /*
            定义可空类型的变量,即变量可以被赋值为null
            定义格式为：修饰符 变量名 ： 类型? = 值
        */
        var nullA: Int? = 12
        val nullB: Int? = 13

        nullA = null

        if (nullA == null) {
            LogUtil.i(TAG + "", "nullA = $nullA")
        }
    }

    /*
        判空
     */
    private fun test1() {
        // if else
        var str: String? = "hello"

        if (null == str) {
            LogUtil.i(TAG, "str == null")
        }

        // ?. 当不为空的时候 才调用后面的属性或者方法
        str?.plus("world")
    }

    /*
        let 操作
            let操作符的作用：当时用符号?.验证的时候忽略掉 let操作
            let的用法：变量?.let{ ... }
     */
    private fun test2() {
        var arr: Array<Int?> = arrayOf(1, 2, null, 4, null, 5)

        // 第一种写法
        for (index in arr) {
            LogUtil.i(TAG, "***** index = $index")
            if (index == null) continue

            LogUtil.i(TAG, "index[${index - 1}] = ${arr[index - 1]}")
        }

        LogUtil.i(TAG, "-------------------------------------------------")

        for (index in arr) {
            index?.let {
                LogUtil.i(TAG, "index = $it")
            }
        }
    }

    /*
        Evils操作符
            Evils其实不是一个操作符，而是evil的复数，而evil的意思在这里可以理解为屏蔽、安全的操作符，
            这样的操作符有三种：
                ?: 这个操作符表示在判断一个可空类型时，会返回一个我们自己设定好的默认值.
                !! 这个操作符表示在判断一个可空类型时，会显示的抛出空引用异常（NullPointException）.
                as? 这个操作符表示为安全的类型转换.
     */
    private fun test3() {
        // ?:操作符
        val testStr: String? = null
        var length = 0
        // 例： 当testStr不为空时，输出其长度，反之输出-1
        // 传统写法
        length = if (testStr != null) testStr.length else -1
        // ?: 写法
        length = testStr?.length ?: -1
        LogUtil.i(TAG, "length: " + length)

        // 使用as?
        val num2: Int? = "Koltin" as? Int
        LogUtil.i(TAG, "nun2 = $num2")
    }
}
