package com.zw.kotlin_android.demo1

/*
    数据类

    数据类的特性
        数据类有着和Kotlin其他类不一样的特性。除了含有其他类的一些特性外，还有着其独特的特点。并且也是数据类必须满足的条件：
        主构造函数需要至少有一个参数
        主构造函数的所有参数需要标记为 val 或 var；
        数据类不能是抽象、开放、密封或者内部的；
        数据类是可以实现接口的，如(序列化接口)，同时也是可以继承其他类的，如继承自一个密封类。
 */
data class Data_Class(var s: String) {

}

data class Data_class1(var s: String, var s1: String)