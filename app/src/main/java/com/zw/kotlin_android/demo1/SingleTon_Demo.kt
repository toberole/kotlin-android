package com.zw.kotlin_android.demo1

/*
饿汉式
懒汉式
线程安全的懒汉式
双重校验锁式
静态内部类式
 */

/*
    单列
 */
// 第一种写法饿汉式 对应的java代码[kotlin 转换为java]
/*
public final class SingleTon_Demo {
   public static final SingleTon_Demo INSTANCE;

   public final void test() {
   }

   private SingleTon_Demo() {
   }

   static {
      SingleTon_Demo var0 = new SingleTon_Demo();
      INSTANCE = var0;
   }
}
 */
object SingleTon_Demo {
    fun test() {

    }
}

// 第二种写法 懒汉式
/*

 */
class SingleTon_Demo1 private constructor() {
    companion object {
        private var instance: SingleTon_Demo1? = null
            get() {
                if (field == null) {
                    field = SingleTon_Demo1()
                }
                return field
            }

        fun get(): SingleTon_Demo1 {
            return instance!!
        }
    }

    fun test() {

    }
}

// 第二种写法 懒汉式 线程安全
/*

 */
class SingleTon_Demo2 private constructor() {
    companion object {
        private var instance: SingleTon_Demo2? = null
            get() {
                if (field == null) {
                    field = SingleTon_Demo2()
                }
                return field
            }

        @Synchronized
        fun get(): SingleTon_Demo2 {
            return instance!!
        }
    }

    fun test() {

    }
}

// 双重校验锁式
class SingleTon_Demo3 private constructor() {
    companion object {
        /*
            Lazy是接受一个 lambda 并返回一个 Lazy 实例的函数，
            返回的实例可以作为实现延迟属性的委托：
                第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果，
                后续调用 get() 只是返回记录的结果。
         */
        val instance: SingleTon_Demo3 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingleTon_Demo3()
        }
    }
}

//静态内部类式 holder
class SingleTon_Demo4 private constructor() {
    companion object {
        var instance = SingleTon_Demo4Holder.instance
    }

    private object SingleTon_Demo4Holder {
        var instance = SingleTon_Demo4()
    }
}