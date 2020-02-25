package com.zw.kotlin_android.utils

import java.util.*

// Kotlin中可以使用一种叫扩展方法的东西，你甚至可以连 class 和 interface 都不写，
// 直接在文件中定义一堆方法，然后全局调用
// 扩展方法不会去覆盖已经存在的方法！！！
fun getUUID(): String = UUID.randomUUID().toString()