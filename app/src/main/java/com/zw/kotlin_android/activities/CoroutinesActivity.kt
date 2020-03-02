package com.zw.kotlin_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.*
import kotlin.math.log

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
        btn_test6.setOnClickListener(this)
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
            R.id.btn_test6 -> {
                test6()
            }
        }
    }

    private fun test6() {
        var intent = Intent(this@CoroutinesActivity, CoroutinesScopeActivity::class.java)
        startActivity(intent)
    }

    /*
    协程作用域
        通过创建一个 CoroutineScope 实例来管理协程的生命周期，
        并使它与 activit 的生命周期相关联。CoroutineScope 可以通过 CoroutineScope() 创建或者通过MainScope() 工厂函数。
        前者创建了一个通用作用域，而后者为使用 Dispatchers.Main 作为默认调度器的 UI 应用程序 创建作用域：
     */
    private var mainScope = MainScope()

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    // 协程上下文与调度器
    /*
        协程总是运行在一些以 CoroutineContext 类型为代表的上下文中，它们被定义在了 Kotlin 的标准库里。

        协程上下文是各种不同元素的集合，其中主元素是协程中的 Job。

        协程上下文包含一个 协程调度器 （参见 CoroutineDispatcher）它确定了哪些线程或与线程相对应的协程执行。
        协程调度器可以将协程限制在一个特定的线程执行，或将它分派到一个线程池，亦或是让它不受限地运行。
        所有的协程构建器诸如 launch 和 async 接收一个可选的 CoroutineContext 参数，它可以被用来显式的
        为一个新协程或其它上下文元素指定一个调度器。
     */
    private fun test5() {
        GlobalScope.launch(context = Dispatchers.Default, start = CoroutineStart.DEFAULT) {
            LogUtil.i(TAG, "1 ...............")
            LogUtil.i(TAG, "1 ...............${Thread.currentThread().name}")

            launch(Dispatchers.IO) {
                LogUtil.i(TAG, "2 ...............${Thread.currentThread().name}")
            }

            launch(Dispatchers.Main) {
                Toast.makeText(this@CoroutinesActivity, "33333333", Toast.LENGTH_SHORT).show()
            }

            var executorCoroutineDispatcher = newSingleThreadContext("hello-thread")
            launch(executorCoroutineDispatcher) {
                LogUtil.i(TAG, "3 ...............${Thread.currentThread().name}")
            }

            /*
                当调用 launch { …… } 时不传参数，
                它从启动了它的 CoroutineScope 中承袭了上下文以及调度器
             */
            launch {
                LogUtil.i(TAG, "4 ...............${Thread.currentThread().name}")
            }

            /*
                非受限调度器 vs 受限调度器

                Dispatchers.Unconfined 协程调度器在调用它的线程启动了一个协程，但它仅仅只是运行到第一个挂起点。
                挂起后，它恢复线程中的协程，而这完全由被调用的挂起函数来决定。非受限的调度器非常适用于执行
                不消耗 CPU 时间的任务，以及不更新局限于特定线程的任何共享数据（如UI）的协程。

                另一方面，该调度器默认继承了外部的 CoroutineScope。 runBlocking 协程的默认调度器，
                特别是， 当它被限制在了调用者线程时，继承自它将会有效地限制协程在该线程运行并且具有可预测的 FIFO 调度。

             */

            launch(Dispatchers.Unconfined) {
                LogUtil.i(TAG, "5 ...............${Thread.currentThread().name}")
            }

            // 打印job
            LogUtil.i(TAG, "job: ${coroutineContext[Job]}")

            /*
                子协程
                    当一个协程被其它协程在 CoroutineScope 中启动的时候， 它将通过 CoroutineScope.coroutineContext
                    来承袭上下文，并且这个新协程的 Job 将会成为父协程作业的 子 作业。当一个父协程被取消的时候，
                    所有它的子协程也会被递归的取消。
                    然而，当使用 GlobalScope 来启动一个协程时，则新协程的作业没有父作业。
                    因此它与这个启动的作用域无关且独立运作。
             */

            /*
            父协程的职责
                一个父协程总是等待所有的子协程执行结束。父协程并不显式的跟踪所有子协程的启动，
                并且不必使用 Job.join 在最后的时候等待它们：
             */
        }
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
