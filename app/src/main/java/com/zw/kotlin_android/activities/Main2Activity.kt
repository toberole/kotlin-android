package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), View.OnClickListener {
    companion object {
        // 需要反射包
        val TAG = Main2Activity::class.simpleName
    }

    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn_toast.setOnClickListener(this)
        btn_op.setOnClickListener(this)
        btn_fun.setOnClickListener(this)
        btn_class1.setOnClickListener {
            Log.i(TAG, "view id: " + it.id)

            var test1 = Test1(1, "hello Test1", 2)
            // 第一种写法
            var m: MyInterface = object : MyInterface {
                override fun callback(errorCode: Int, errorMsg: String) {
                    Log.i(TAG, "1------ " + errorCode + ",errorMsg: " + errorMsg)
                }
            }
            test1.setCB(m)
            test1.test()

            // 第二种写法
            var m1: MyInterface = MyInterface_Impl()
            test1.setCB(m1)
            test1.test()

            // 传递函数实现类似回调的效果
            test1.setCB1(this::callback)
            test1.test1()
            val cb1 = fun(c: Int, s: String): Unit {
                Log.i(TAG, "xxxxxxxxxxxxxxxxxxx")
            }
            test1.setCB1(cb1)
            test1.test1()
        }

        btn_class2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_toast -> {
                userName = et_username.text.toString().trim()
                if (!TextUtils.isEmpty(userName)) {
                    Log.i(TAG, "userName: " + userName)
                    Toast.makeText(this@Main2Activity, userName, Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btn_op -> {
                var num1 = et_num1.text?.toString()?.trim()?.toInt()
                var num2 = et_num2.text?.toString()?.trim()?.toInt()
                var num3: Int? = num2?.let { num1?.plus(it) }

                tv_res.text = num3.toString()
            }

            // 一个函数可以将另一个函数当作参数。将其他函数用作参数的函数称为“高阶函数”。
            // 此模式对组件之间的通信（其方式与在 Java 中使用回调接口相同）很有用。
            R.id.btn_fun -> {
                sync_fun("hello", this::callback)// 注意写法
            }

            R.id.btn_class2 -> {
                var stu = Student(0)
                Log.i(TAG, "Student age: " + stu.age)

                var stu1 = Student1(1)
                Log.i(TAG, "Student1 age: " + stu1.age)

                var stu2 = Student2(2)
                Log.i(TAG, "Student2 age: " + stu2.age)

                var stu3 = Student3(3)
                Log.i(TAG, "Student3 age: " + stu3.age)

                var stu4 = Student4(4, 5)
                Log.i(TAG, "Student4 age: " + stu4.age + ",age1: " + stu4.age1)

                var cat = Cat()
                cat.weight = 100f
                cat.sys()
            }

        }
    }

    suspend fun getData(): String {
        Log.i("xc", "getData ......")
        return "Hello"
    }

    fun sync_fun(user: String, cb: (Int, String) -> Unit) {
        Log.i(TAG, "sync_fun user: " + user)
        cb(-1, user)
    }

    fun callback(errorCode: Int, errorMsg: String) {
        Log.i(TAG, "callback errorCode: " + errorCode + ",errorMsg: " + errorMsg)
    }


}
