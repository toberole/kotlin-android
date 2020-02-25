package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import com.zw.kotlin_android.utils.getUUID

/*
Kotlin:
    public：默认，总是可见
    internal：同模块可见，起保护作用，防止模块外被调用
    private：仅在同一个文件中可见
    protected：类似于private，但对子类也可见
 */

class Main4Activity : AppCompatActivity() {
    companion object {
        val TAG = Main4Activity::class.java.simpleName
    }

    //    Kotlin中使用 val 关键字来声明一个只读常量(final，定义后，如果去修改变值是会报错)，
    //    而使用 var 关键字来声明一个变量！
    val str1: String = "hello"
    var str2: String? = null
    // 类型推断
    var str3 = "hello"
    // 延迟初始化
    lateinit var str4: String

    // 只读属性可以使用适合放在一行上的较短语法。
    val defaultExtension: String get() = "kt"

    private val s1: String = getStr()
    private val s2 = getStr()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var uuid = getUUID()
        LogUtil.i(TAG, "uuid: " + uuid)

        var res = sum(1, 2, 3, 4, 5)
        LogUtil.i(TAG, "res: " + res)
    }

    // 隐式返回/属性类型
    // 如果表达式函数主体或属性初始化式是标量值，或者可以根据主体明确推断出返回类型，则可以将其省略。
    private fun test1(): String = "hello"

    private fun test1_1() = "hello"

    private fun getStr(): String {
        return "hello"
    }

    // 可变参数
    fun sum(vararg numbers: Int): Int {
        var res = 0
        for (num in numbers) {
            res += num
        }

        return res
    }
}
