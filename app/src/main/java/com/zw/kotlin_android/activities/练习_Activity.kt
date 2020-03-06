package com.zw.kotlin_android.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.*
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_lianxi.*
import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Lock
import kotlin.coroutines.CoroutineContext

inline fun <T> check(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

class 练习_Activity : AppCompatActivity(), View.OnClickListener {
    var TAG = 练习_Activity::class.java.simpleName + "_xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lianxi)

        btn_token.setOnClickListener(this)
        btn_token1.setOnClickListener(this)

        var hello = Hello("hello world")
        hello.sys()
        hello.test("huhuhuhu")

        test3()

        var a: CoroutineContext

        // 线程池转化为 CoroutineDispatcher
        ThreadPoolExecutor(1, 1,
                30, TimeUnit.SECONDS, LinkedBlockingQueue())
                .asCoroutineDispatcher()

        GlobalScope.launch {

        }

        var demox1 = Demo_x(100)
        var demox2 = Demo_x(200)
        demox1 + demox2
        LogUtil.i("plus-xxx", "" + demox1.i)
    }

    /*
        let also
     */
    private fun test3() {
//        let函数：返回值 = 最后一行 / return的表达式
//        also函数：返回值 = 传入的对象的本身

        // let
        tv_test.let {
            it.setText("" + System.currentTimeMillis())
            it.setTextColor(Color.RED)
        }

        // also
        tv_test.also {
            tv_test.setTextColor(Color.GREEN)
        }

//        with函数
//        调用同一个对象的多个方法 / 属性时，可以省去对象名重复，直接调用方法名 / 属性即可
        with(tv_test) {
            setTextColor(Color.RED)
            setText("" + System.currentTimeMillis())
        }

        // run
//        调用同一个对象的多个方法 / 属性时，可以省去对象名重复，直接调用方法名 / 属性即可
//        定义一个变量在特定作用域内
//        统一做判空处理
//        返回值 = 函数块的最后一行 / return表达式
        tv_test.run {
            var s = "hello"
            setText("========" + s)
        }

        // apply
        // apply函数返回传入的对象的本身
        tv_test.apply {
            setText("${System.currentTimeMillis()}")
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_token -> {
                test1()
            }
            R.id.btn_token1 -> {
                test2()
            }
        }
    }

    /*
        传统回调
     */
    private fun test1() {
        var reuqest = TokenRequest("", object : TokenRequestCallback {
            override fun onError(errorCode: Int, errorMsg: String?) {
                LogUtil.i(TAG, "errorCode: $errorCode,errorMsg: $errorMsg")
            }

            override fun onSuccess(res: String?) {
                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(this@练习_Activity, res, Toast.LENGTH_SHORT).show()
                }
            }
        })

        reuqest.getToken()
    }

    /*
        高阶函数代替回调
     */
    private fun test2() {
        var request = TokenRequest1("", { errorCode: Int, errorMsg: String ->
            LogUtil.i(TAG, "errorCode: $errorCode,errorMsg: $errorMsg")
        }, { res: String ->
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(this@练习_Activity, res, Toast.LENGTH_SHORT).show()
            }
        })

        request.getToken()
    }
}
