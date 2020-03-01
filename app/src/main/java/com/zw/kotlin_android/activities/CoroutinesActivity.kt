package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity(), View.OnClickListener {
    var TAG = "cs-xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
        btn_test3.setOnClickListener(this)
        btn_test4.setOnClickListener(this)
        btn_test5.setOnClickListener(this)
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
            R.id.btn_test5 -> {
                test5()
            }
        }
    }

    private fun test5() {

    }

    suspend fun failedConcurrentSum(): Int = coroutineScope {
        val one = async<Int> {
            try {
                delay(Long.MAX_VALUE) // 模拟一个长时间的运算
                42
            } finally {
                println("First child was cancelled")
            }
        }
        val two = async<Int> {
            println("Second child throws an exception")
            throw ArithmeticException()
        }
        one.await() + two.await()
    }

    // async 风格的函数
    private fun test4() {
        somethingUsefulOneAsync()
        somethingUsefulTwoAsync()
    }

    fun somethingUsefulOneAsync() = GlobalScope.async {
        LogUtil.i(TAG, "somethingUsefulOneAsync ......")
    }

    // somethingUsefulTwoAsync 函数的返回值类型是 Deferred<Int>
    fun somethingUsefulTwoAsync() = GlobalScope.async {
        LogUtil.i(TAG, "somethingUsefulTwoAsync ......")
    }


    private fun test3() {
        GlobalScope.launch(Dispatchers.IO) {
            LogUtil.i(TAG, "out thread: ${Thread.currentThread().name}")

            var t = System.currentTimeMillis()
            var one = async {
                LogUtil.i(TAG, "one thread: ${Thread.currentThread().name}")
                delay(1000)
                1 + 1
            }

            var two = async {
                LogUtil.i(TAG, "two thread: ${Thread.currentThread().name}")
                delay(2000)
                2 + 2
            }

            LogUtil.i(TAG, "one = ${one.await()},two = ${two.await()}")
            LogUtil.i(TAG, "time = ${System.currentTimeMillis() - t}")

            //        惰性启动的 async
//                可选的，async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。
//                在这个模式下，只有结果通过 await 获取的时候协程才会启动，或者在 Job 的 start 函数调用的时候。
            var t1 = async(context = Dispatchers.IO, start = CoroutineStart.LAZY) {
                LogUtil.i(TAG, "t1 thread: ${Thread.currentThread().name}")
            }
            t1.start()

        }


    }

    var b: Boolean = true
    var job: Job? = null
    private fun test2() {
        if (b) {
            // 开启协程
            job = GlobalScope.launch(Dispatchers.Default) {
                delay(2000)
                LogUtil.i("cs-xxx", "协程运行 test2 ....")
                withContext(Dispatchers.Default) {

                }

                async(Dispatchers.Default) {

                }
            }

        } else {
            // 关闭协程
            job?.cancel()
            LogUtil.i("cs-xxx", "协程关闭 ....")
        }

        b = !b
    }

    private fun test1() {
        LogUtil.i("cs-xxx", "test1 Thread name: ${Thread.currentThread().name}")

        GlobalScope.launch {
            var t = System.currentTimeMillis()
            delay(1000)
            LogUtil.i("cs-xxx", "Thread name: ${Thread.currentThread().name}")
            LogUtil.i("cs-xxx", "time = ${System.currentTimeMillis() - t}")
        }

//        runBlocking {// 会阻塞当前线程
//
//        }
    }
}
