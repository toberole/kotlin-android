package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil

/*
    写在类头部的构造函数 一般称为主构造器
    写在类内部的额构造函数 称为辅助构造器,可以通过this()调用其他辅助构造器，但是任何一个辅助构造器都必须调用主构造器！
 */
class Person(var name: String/*主构造器*/) {
    var age: Int = 0
        get() = age
        set(value) {
            field = value
        }

    init {
        LogUtil.i("person", "init ......")
    }

    constructor(age: Int, name: String) : this(name) {
        this.age = age
    }

    fun sys() {
        LogUtil.i("person", "name: " + name)
    }

    override fun toString(): String = "age = $age,name = $name"
}

// 私有主构造器
class Person1 private constructor(name: String) {
    constructor(name: String, age: Int) : this(name) {

    }
}

// open 表示 可以被继承
open class Person2 constructor(name: String) {
    // 不能被重写
    fun m1() {
        LogUtil.i("Person2", "m1 ......")
    }

    // open 能够被重写
    open fun m2() {
        LogUtil.i("Person2", "m2 ......")
    }
}

class Person3(name: String) : Person2(name) {
    override fun m2() {
        super.m2()
        LogUtil.i("Person3", "m2 ......")
    }
}

// 接口

interface ITest {
    // 接口中的属性必须是抽象的，或者提供访问器的自定义实现！
    var id: Int// 抽象属性

    var id1: Int
        get() = id1
        set(value) {
            id1 = value
        }
}

// 类可以嵌套在其他类中，如果只是简单的嵌套，内部类是无法访问外部类成员的！
// 如果你想在内部类中访问外部成员，你需要使用 inner 关键字进行声明。
// 匿名内部类，Kotlin中会自动转成lambda表达式的形式，比如设置点击事件
class Inner_class {
    var i: Int = 0

    class C1 {
        // 不能访问 i
        fun print() {
            //  LogUtil.i("C1","C1 = $i")
        }
    }

    inner class C2 {
        // 可以访问 i
        fun print() {
            LogUtil.i("C1", "C1 = $i")
        }
    }
}

//Kotlin中 没有静态属性和方法，如果你想实现类似于单例的功能，
//可以使用关键字 object 声明一个对象，对象的构造器不能提供构造器参数，
//在第一次使用的时候会被初始化，可用于提供常量或共享不可变对象！
object Singleton {
    fun init(path: String) {
        LogUtil.i("Singleton", "path = $path")
    }
}


//伴生对象
//除了上面的单例对象外，Kotlin 中还提供了伴生对象这种东西，使用 companion关键字声明，
//可以直接 类.成员 访问成员，有点类似与静态成员，但是在运行时，他们依旧是实体的实例成员，
//另外，使用companion关键字时，伴生对象的名称可以省略！
class Com_class {
    companion object {
        var name: String = "hello"
    }
}

class Test_Com_class {
    fun test() {
        LogUtil.i("Test_Com_class", Com_class.name)
    }
}












