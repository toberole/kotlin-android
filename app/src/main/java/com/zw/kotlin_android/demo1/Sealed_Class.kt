package com.zw.kotlin_android.demo1

/*
    密封类
        密封类是用来表示受限的类继承结构,密封类不能被实例化
    申明格式：
        sealed class class_name()

    1、什么是受限的类继承结构
        所谓受限的类继承结构，即当类中的一个值只能是有限的几种类型，而不能是其他的任何类型。
        这种受限的类继承结构从某种意义上讲，它相当于是枚举类的扩展。但是，我们知道Kotlin的枚举类中的枚举常量是受限的，因为每一个枚举常量只能存在一个实例。若对Kotlin中的枚举类不甚了解的，请参见我的另一篇文章Kotlin——中级篇（五）：枚举类（Enum）、接口类（Interface）详解。
        但是其和枚举类不同的地方在于，密封类的一个子类可以有可包含状态的多个实例。
        也可以说成，密封类是包含了一组受限的类集合，因为里面的类都是继承自这个密封类的。但是其和其他继承类（open）的区别在，密封类可以不被此文件外被继承，有效保护代码。但是，其密封类的子类的扩展是是可以在程序中任何位置的，即可以不再统一文件下。
 */

sealed class Sealed_Class() {
    data class PP(var s: String) : Sealed_Class() {

    }

    object ADD : Sealed_Class()
}

class T(var s1: String, var s2: String) : Sealed_Class() {

}

