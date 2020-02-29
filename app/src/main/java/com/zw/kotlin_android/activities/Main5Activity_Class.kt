package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.Data_class1
import com.zw.kotlin_android.demo1.Person
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main5__class.*

class Main5Activity_Class : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5__class)

        var data_class1 = Data_class1("hello", "world")
        LogUtil.i("data-xxx", data_class1.toString())

        // 使用copy修改部分属性
        var data_class2 = Data_class1("a", "b")
        LogUtil.i("data-xxx", "tostring = ${data_class2.toString()}, hashCode = ${data_class2.hashCode()}")
        var data_class3 = data_class2.copy(s = "a_1")
        LogUtil.i("data-xxx", "tostring = ${data_class3.toString()}, hashCode = ${data_class3.hashCode()}")

        // 解构声明
        var data_class4 = Data_class1("解构声明 s", "解构声明 s1")
        var (s, s1) = data_class4
        LogUtil.i("data-xxx", "s = $s,s1 = $s1")

        // 匿名内部类
        btn_test1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                LogUtil.i("Main5", "btn_test1 onClicked ......")
            }
        })

        // 匿名内部类中只有一个方法的时候 可以直接写成lambda表达式，
        // 但是不是一个方法的时候 可以按照btn_test1的方法处理
        btn_test2.setOnClickListener {
            LogUtil.i("Main5", "btn_test2 onClicked ......")
        }

        btn_test3.setOnClickListener(View.OnClickListener {
            LogUtil.i("Main5", "btn_test3 onClicked ......")
        })

        test1()
    }

    private fun test2() {
        Looper.prepare()
        Looper.loop()
    }

    private fun test1() {
        var p = Person("hello person")
        p.sys()
        var p1 = Person(11, "xiaohong")
        LogUtil.i("person", "p1: " + p1)
    }
}

/*
类定义与对象实例化
    Kotlin中不同于Java，允许在一个文件中定义多个类，另外，类实体是可选的，就是直接
    class Test 这样，对的不用疑惑，可以不写大括号，当然这个一般用于表示概念(没什么
    卵用)。而实例化类对象以及调用成员方法也很简单：
 */
