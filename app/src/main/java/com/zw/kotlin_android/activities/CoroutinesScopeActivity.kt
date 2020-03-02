package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.coroutines.*

/*
 委托实现CoroutineScope
 */
class CoroutinesScopeActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Default) {
    var TAG = CoroutinesScopeActivity::class.java.simpleName + "-xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_scope)

        test()
    }

    private fun test() {
        launch {
            LogUtil.i(TAG, "Thread.Name = ${Thread.currentThread().name}")
        }
    }

    // ThreadLocal
    private fun test1() {
        var threadLocal = ThreadLocal<String>()
        threadLocal.set("main")
        launch {
            println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")

            val job = launch(Dispatchers.IO + threadLocal.asContextElement(value = "launch")) {
                println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
                yield()
                println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
            }
            job.join()
            println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        }
    }
}
