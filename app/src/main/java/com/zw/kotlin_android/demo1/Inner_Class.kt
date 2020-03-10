//package com.zw.kotlin_android.demo1
//
//import com.zw.kotlin_android.utils.LogUtil
//
//class Inner_Class {
//    var TAG = this.javaClass.simpleName
//
//    val num = 1
//
//    // 嵌套类 不能访问外部类的属性和成员
//    class Class_Demo {
//        fun init() {
//            LogUtil.i("Class_Demo", "init ......")
//        }
//    }
//
//    // 嵌套内部类
//    inner class Class_Demo_Inner {
//        fun init() {
//            LogUtil.i("", "init num = $num ......")
//        }
//    }
//
//    fun partMethod() {
//        var partName = "hello"
//
//        // 局部类 即定义在方法（函数）中的类。
//        /*
//            局部类只能在定义该局部类的方法中使用。
//            定义在实例方法中的局部类可以访问外部类的所有变量和方法。但不能修改
//            局部类中的可以定义属性、方法。并且可以修改局部方法中的变量。
//         */
//        class Part_Class {
//            var ss = "hhh"
//            fun test() {
//                LogUtil.i("", "ss = $ss,partName = $partName，num = $num")
//            }
//        }
//
//        val part = Part_Class()
//        part.test()
//    }
//}
//
//fun test_Inner_Class() {
////    // 嵌套类
////    Inner_Class.Class_Demo().init()
////
////    // 嵌套内部类
////    Inner_Class().Class_Demo_Inner().init()
//}