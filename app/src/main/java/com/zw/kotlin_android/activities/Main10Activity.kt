package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.Extend_Class
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main10.*

/*
    扩展
        Kotlin 能够扩展一个类的新功能而无需继承该类或者使用像装饰者这样的设计模式。
        这通过叫做 扩展 的特殊声明完成。 例如，你可以为一个你不能修改的、来自第三方库中的类编写一个新的函数。
        这个新增的函数就像那个原始类本来就有的函数一样，可以用普通的方法调用。
        这种机制称为 扩展函数 。此外，也有 扩展属性 ， 允许你为一个已经存在的类添加新的属性。

    扩展是静态解析的
        扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
        我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
 */
class Main10Activity : AppCompatActivity(), View.OnClickListener {
    var TAG = Main10Activity::class.simpleName

    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType() {
        println("Extension function")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        btn_test.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test -> {
                test_method()
            }
        }
    }

    /*
        扩展函数
        声明一个扩展函数，需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。
     */
    private fun test_method() {
        var e = Extend_Class("hello extend")
        e.p()
        e.test()

        /*
        扩展是静态解析的
            扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
            我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
         */
        printClassName(Rectangle())

        /*
            如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同的接收者类型、 相同的名字，
            并且都适用给定的参数，这种情况总是取成员函数。
         */
        var ex = Example()
        ex.printFunctionType()
    }

    // 扩展Extend_Class
    // 给Extend_Class扩展一个test函数
    fun Extend_Class.test() {
        // this 指的是Extend_Class 对象
        LogUtil.i(TAG /* TAG 是Extend_Calss中的TAG */ + "", "扩展函数 test str = ${this.str}")
    }


}


//////////////////////////////////  1 ///////////////////////////////////
open class Shape

class Rectangle : Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    LogUtil.i("getName", s.getName())
}
//////////////////////////////////  1 ///////////////////////////////////

