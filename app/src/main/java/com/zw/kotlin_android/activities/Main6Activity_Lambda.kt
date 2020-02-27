package com.zw.kotlin_android.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main6__lambda.*

/*
Lambda表达式:
    Lambda表达式总是被大括号括着
    其参数(如果存在)在 -> 之前声明(参数类型可以省略)
    函数体(如果存在)在 -> 后面。

 */

/*
    语法如下：
        1. 无参数的情况 ：
        val/var 变量名 = { 操作的代码 }

        2. 有参数的情况
        val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }

        可等价于
        // 此种写法：即表达式的返回值类型会根据操作的代码自推导出来。
        val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }

        3. lambda表达式作为函数中的参数的时候，这里举一个例子：
        fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){
            ...
        }
 */

/*
it
    it并不是Kotlin中的一个关键字(保留字)。
    it是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数。
    it可表示为单个参数的隐式名称，是Kotlin语言约定的。
 */
class Main6Activity_Lambda : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6__lambda)

        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
        btn_test3.setOnClickListener(this)
        btn_test4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                test1()
            }

            R.id.btn_test2 -> {
                test2()
            }

            R.id.btn_test3 -> {
                test3()
            }

            R.id.btn_test4 -> {
                test4()
            }
        }
    }

    /*
        闭包
     */
    private fun test4() {
        var t = test4_1(1)
        LogUtil.i("lambda", "${t()}")
        LogUtil.i("lambda", "${t()}")
        LogUtil.i("lambda", "${t()}")

        var sum: Int = 0
        val arr = arrayOf(1, 3, 5, 7, 9)
        arr.filter { it < 7 }.forEach { sum += it }
        LogUtil.i("lambda", "sum = $sum")
    }

    private fun test4_1(a: Int): () -> Int {
        var b = 1
        return fun(): Int {
            LogUtil.i("lambda", "b = $b")
            b++
            return a + b
        }
    }

    private fun test1() {
        LogUtil.i("lambda", "test1 ......")

        // 类似与函数变量
        var test1_1 = {
            LogUtil.i("lambda", "test1_1 ......")
        }
        test1_1()

        var test1_2: (Int, Int) -> Int = { a: Int, b: Int ->
            LogUtil.i("lambda", "test1_2 $a + $b = ${a + b}")
            a + b
        }
        test1_2(1, 3)

        var test1_2_1 = { a: Int, b: Int ->
            LogUtil.i("lambda", "test1_2_1 $a + $b = ${a + b}")
            a + b
        }
        test1_2_1(1, 2)

        test_m(1, test1_2)
        test_m(2, { num1: Int, num2: Int -> num1 + num2 })
    }

    // lambda 作为函数参数
    fun test_m(a: Int, m: (x: Int, y: Int) -> Int/* lambda 参数 */): Int {
        LogUtil.i("lambda", "test_m ......")
        return a + m.invoke(a, a)
    }

    /*
        it
        it并不是Kotlin中的一个关键字(保留字)。
        it是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数。
        it可表示为单个参数的隐式名称，是Kotlin语言约定的。
    */
    fun test_it_(num1: Int, b: (Int) -> Boolean): Int {
        return if (b(num1)) {
            num1
        } else 0
    }

    fun test_it() {
        println(test_it_(10, { it > 5 }))
        println(test_it_(4, { it > 5 }))
    }

    private fun test2() {
        // 下划线（_）
        // 在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数。
        val map = mapOf("key1" to "value1", "key2" to "value2", "key3" to "value3")
        map.forEach { key, value ->
            LogUtil.i("lambda", "$key \t $value")
        }
        // 不需要key的时候
        map.forEach { _, value ->
            LogUtil.i("lambda", "$value")
        }
    }

    //    匿名函数
//    匿名函数的特点是可以明确指定其返回值类型。
//    它和常规函数的定义几乎相似。他们的区别在于，匿名函数没有函数名。
    private fun test3() {
        val test3_1 = fun(x: Int, y: Int) = x + y  // 当返回值可以自动推断出来的时候，可以省略，和函数一样
        val test3_2 = fun(x: Int, y: Int): Int = x + y
        val test3_3 = fun(x: Int, y: Int): Int {
            return x + y
        }

        LogUtil.i("lambda", "test3 test3_1: ${test3_1(1, 2)}")
    }
}
