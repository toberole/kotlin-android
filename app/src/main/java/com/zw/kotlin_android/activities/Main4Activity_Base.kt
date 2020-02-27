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

/*
    声明常量的三种正确方式
        1、在顶层声明
        2、在object修饰的类中声明，在kotlin中称为对象声明，它相当于Java中一种形式的单例类
        3、在伴生对象中声明
 */

// 1. 顶层声明
const val NUM_A: String = "顶层声明"

// 2. 在object修饰的类中
object TestConst {
    const val NUM_B = "object修饰的类中"
}

// 3. 伴生对象中
class TestClass {
    companion object {
        const val NUM_C = "伴生对象中声明"
    }
}


class Main4Activity_Base : AppCompatActivity() {
    companion object {
        val TAG = Main4Activity_Base::class.java.simpleName
    }

    //    var: 用此关键字声明的变量表示可变变量，即可读且可写。相当于Java中普通变量
//    val: 用此关键字声明的变量表示不可变变量，即可读且不可写。相当于Java中用final修饰的变量
    var v1: Int = 0
    val v2: Int = 0
    var v3 = 0


    //    Kotlin中使用 val 关键字来声明一个只读常量(final，定义后，如果去修改变值是会报错)，
    //    而使用 var 关键字来声明一个变量！
    val str1: String = "hello"
    var str2: String? = null
    // 类型推断
    var str3 = "hello"
    // 延迟初始化
    lateinit var str4: String
    // lateinit 不能是可空的
    // lateinit var str4_1: String?
    // 不能用于基本数据类型
    // lateinit var i: Int

    // 只读属性可以使用适合放在一行上的较短语法。
    val defaultExtension: String get() = "kt"

    private val s1: String = getStr()
    private val s2 = getStr()

    /*
        延迟初始化属性
            所谓延迟初始化即：
                指当程序在第一次使用到这个变量（属性）的时候才初始化。
            声明延迟初始化属性的特点：
                使用lazy{}高阶函数，不能用于类型推断。且该函数在变量的数据类型后面，用by链接。
                必须是只读变量，即用val声明的变量。
     */
    private val strs: Array<String> by lazy {
        arrayOf(
                "hello", "world"
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var uuid = getUUID()
        LogUtil.i(TAG, "uuid: " + uuid)

        var res = sum(1, 2, 3, 4, 5)
        LogUtil.i(TAG, "res: " + res)

        test2(1, 2)
    }

    // 隐式返回/属性类型
    // 如果表达式函数主体或属性初始化式是标量值，或者可以根据主体明确推断出返回类型，则可以将其省略。
    private fun test1(): String = "hello"

    private fun test1_1() = "hello"

    private fun getStr(): String {
        return "hello"
    }

    // 数组
//    Kotlin中使用 Array 类表示数组，
//    需注意一点：[]访问数组元素在这里实际上是进行了操作符的
//    重载，调用的其实是Array类的getter和setter方法，但是编译成字节码的时候会进行优化，
//    变成直接访问数组的内存地址，
    fun test3() {
        // 定长数组
        val fixedSizeArray = arrayOfNulls<Int>(10)
        // 空数组
        val empty = emptyArray<Int>()
        // 装箱操作
        val arr = arrayOf(1, 2, 3) //还有其他比如IntArrayOf，BooleanArrayOf等

        // 闭包初始化
        val array = Array(10, { num -> num })
        for (i in array) {
            LogUtil.i(TAG, "arr: " + i)
        }

        array[0] = array[0] + 1

        array.forEach {
            LogUtil.i(TAG, "arr: " + it)
        }
    }

    // 字符串模板
    fun test2(a: Int, b: Int) {
        LogUtil.i(TAG, "test2 $a + $b = {$a + $b}")
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
