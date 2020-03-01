package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main9.*

class Main9Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        btn_object.setOnClickListener(this)
        btn_companion_object.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_object -> {
                test_bject()
            }
            R.id.btn_companion_object -> {

            }
        }
    }

    /*
     object关键字
        object 关键字可以表达两种含义：一种是对象表达式,另一种是 对象声明。
     */
    private fun test_bject() {
        // OnClickListener 是一个匿名类的对象，用object来修饰。
        btn_test.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
        LogUtil.i("demo-xxx", "demo str = ${Demo.str}")
        Demo.sys()
    }
}

// object 对象
// 用object 修饰的类为静态类，里面的方法和变量都为静态的。
object Demo {
    var str = "hello"

    fun sys() {
        LogUtil.i("demo-xxx", "str = $str")
    }
}

// 声明静态内部类
// 类内部的对象声明，没有被inner 修饰的内部类都是静态的
class Demo_O {
    object Demo_class {

    }
}

class C_O {
    // companion object
    // companion object 修饰为伴生对象,伴生对象在类中只能存在一个，
    // 类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
    companion object {
        private val TAG = "DemoManager"

        fun b() {
            LogUtil.e(TAG, "此时 companion objec t表示 伴生对象")
        }
    }
}