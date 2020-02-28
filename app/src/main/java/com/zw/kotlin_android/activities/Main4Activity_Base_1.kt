package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil


class Main4Activity_Base_1 : AppCompatActivity() {
    val TAG = Main4Activity_Base_1::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4__base_1)
        test2()
    }

    /*
        数据类型
            Byte=> 字节 => 8位
            Short => 短整型 => 16位
            Int => 整型 => 32位
            Long => 长整型 => 64位
            Float => 浮点型 => 32位
            Double => 双精度浮点型 => 64位
     */
    private fun test() {
        var a: Byte = 0
        var b: Short = 1
        var c: Int = 2
        var d: Long = 3L
        var e: Float = 4F
        var f: Double = 5.toDouble()

        LogUtil.i("data-xxx", "a = {$a} \n b = {$b} \n")
    }

    /*
         二进制数
        八进制数（Kotlin不支持）
        十进制数
        十六进制数
     */
    private fun test1() {
        var a = 0x11// 16进制
        var b = 0b11// 2进制
        var c = 123
        LogUtil.i("data-xxx", "a = $a,b = $b,c = $c")
    }

    /*
        装箱拆箱
在Kotlin中，存在数字的装箱，但是不存在拆箱。因为Kotlin是没有基本数据类型的，Kotlin是万般皆对象的原则。
故不存在和Java中的类似int是数据类型，Integer是整型的引用类型。
     */
    private fun test2() {
        val numValue: Int = 123
        //装箱的过程，其实装箱之后其值是没有变化的
        val numValueBox: Int? = numValue
        LogUtil.i("data-xxx", "装箱后： numValueBox => $numValueBox")

        // 判断相等
        var a = 1111
        var b = 1111
        var bool = false
        // == 值相等
        bool = (a == b)
        LogUtil.i("data-xxx", "$a == $b $bool")
        // === 内存地址
        bool = (a === b)
        LogUtil.i("data-xxx", "$a === $b $bool")

        // 注意jvm对小数字的缓存
        a = 100
        b = 100
        // == 值相等
        bool = (a == b)
        LogUtil.i("data-xxx", "$a == $b $bool")
        // === 内存地址
        bool = (a === b)
        LogUtil.i("data-xxx", "$a === $b $bool")

        LogUtil.i("data-xxx", "97 tochar ${97.toChar()}")
    }
}
