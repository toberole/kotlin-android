package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_cor_flow.*

class 协程异步流_Activity : AppCompatActivity(), View.OnClickListener {
    var TAG = 协程异步流_Activity::class.java.simpleName + "-xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cor_flow)


//        class = class com.zw.kotlin_android.activities.协程异步流_Activity
//        class.java = class com.zw.kotlin_android.activities.协程异步流_Activity
        LogUtil.i(TAG, "class = ${协程异步流_Activity::class}")
        LogUtil.i(TAG, "class.java = ${协程异步流_Activity::class.java}")

        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                test1()
            }
            R.id.btn_test2 -> {
                test2()
            }
        }
    }

    private fun test1() {
        var list = listOf<Int>(1, 2, 3)
        list.forEach {
            LogUtil.i(TAG, "test1 value = $it")
        }
    }

    private fun test2() {
        test2_0().forEach {
            LogUtil.i(TAG, "test2 value = $it")
        }
    }

    /*
        序列
     */
    private fun test2_0(): Sequence<Int> = sequence {
        for (i in 1..3) {
            Thread.sleep(100)
            yield(i)
        }
    }

    private fun test3() {

    }
}
