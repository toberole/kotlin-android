package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.zw.kotlin_android.R
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.coroutines.*

/*
使用协程
run(CoroutineContext) { ... }:
    创建一个运行在CoroutineContext制定线程中的区块，效果是运行在CoroutineContext线程中并且挂起父coroutine上下文直到区块执行完毕
runBlocking(CoroutineContext) { ... }:
    创建一个coroutine并且阻塞当前线程直到区块执行完毕，这个一般是用于桥接一般的阻塞试编程方式到coroutine编程方式的，不应该在已经是coroutine的地方使用
launch(CoroutineContext) { ... }:
    创建运行在CoroutineContext中的coroutine，返回的Job支持取消、启动等操作，不会挂起父coroutine上下文；可以在非coroutine中调用
suspend fun methodName() { ... }:
    申明一个suspend方法，suspend方法中能够调用如delay这些coroutine特有的非阻塞方法；需要注意的是suspend方法只能在coroutine中执行
async(CoroutineContext) { ... }:
    创建运行在CoroutineContext中的coroutine，并且带回返回值(返回的是Deferred，可以通过await等方式获得返回值)

 */
class Main3Activity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var TAG = Main3Activity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn_xc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_xc -> {
                test5()
            }
        }
    }

    private fun test1() {
        GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.IO) {
                delay(5000)
            }.await()
            Toast.makeText(this@Main3Activity, "finish async job but not block main thread", Toast.LENGTH_SHORT).show()
        }

        Log.i(TAG, "test1 ......")
    }

    private fun test2() {
        GlobalScope.launch(Dispatchers.Default) {
            var job = async {
                delay(3000)
                "hello test2"
            }
            var s = job.await()
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(this@Main3Activity, s, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun test3() {
        GlobalScope.launch(Dispatchers.IO) {
            Log.i(TAG, "before test3_1 ......")
            var s = test3_1()
            Log.i(TAG, "after test3_1 ......")

            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(this@Main3Activity, s, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * suspend 用于暂停执行当前协程，并保存所有局部变量。
     * resume 用于让已暂停的协程从其暂停处继续执行。
     */
    private suspend fun test3_1(): String {// suspend 标记的方法只能在协程中使用
        delay(5000)
        return "hello test3_1"
    }

    // 只有一句表达式的函数 可以省略“{}”
    private fun test4(i: Int): Int = i + 1

    // 无参数 无返回值 只有一句表达式的函数
    private fun test5() = runOnUiThread {
        Toast.makeText(this@Main3Activity, "无参数 无返回值 只有一句表达式的函数", Toast.LENGTH_SHORT).show()
    }
}

/*
suspend方法只能在协程或者另一个suspend方法中被调用.
在协程等待的过程中, 线程会返回线程池, 当协程等待结束, 协程会在线程池中一个空闲的线程上恢复.

启动协程
启动一个新的协程, 常用的主要有以下几种方式:
launch、async、runBlocking
它们被称为coroutine builders. 不同的库可以定义其他更多的构建方式.

runBlocking: 连接blocking和non-blocking的世界
runBlocking用来连接阻塞和非阻塞的世界.
runBlocking可以建立一个阻塞当前线程的协程. 所以它主要被用来在main函数中或者测试中使用, 作为连接函数.


 */
