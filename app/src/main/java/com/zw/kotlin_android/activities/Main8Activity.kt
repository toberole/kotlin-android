package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main8.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
    集合操作
 */
class Main8Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        btn_list.setOnClickListener(this)
        btn_set.setOnClickListener(this)
        btn_map.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_list -> {
                test_list()
            }
            R.id.btn_map -> {
                test_map()
            }
            R.id.btn_set -> {
                test_set()
            }
        }
    }

    private fun test_list() {
//        声明并初始化List的集合：使用listOf(..)函数
//        声明并初始化MutableList的集合：使用mutableListOf(..)函数

        var arr = arrayOf<Int>(1, 2, 3, 4, 5)
        var list = listOf<Int>(1, 2, 3, 4, 5)

        for (v in arr) {
            LogUtil.i("list-xxx", "arr v = $v")
        }

        for (v in list) {
            LogUtil.i("list-xxx", "list v = $v")
        }

        var m_list = mutableListOf<Int>(1, 2, 3, 4, 5)
        m_list.add(6)
        for (v in m_list) {
            LogUtil.i("list-xxx", "m_list v = $v")
        }

        var m_list1 = ArrayList<Int>()
        var m_list2 = LinkedList<Int>()

    }

    private fun test_map() {
//        不可变的Map类型集合的初始化使用：mapOf()函数
//        可变的Map类型集合的初始化使用：mutableMapOf()函数
        var map = mapOf<String, String>("name" to "xiaohong", "age" to "11")
        var m_map = mutableMapOf<String, String>("name" to "xiaoli", "age" to "22")
        var m_map1 = HashMap<String, String>()
        m_map.put("xxx", "xxx")
    }

    private fun test_set() {
//        声明并初始化Set的集合：使用setOf(..)函数
//        声明并初始化MutableSet的集合：使用mutableSetOf(..)函数

        var set1 = setOf<Int>(1, 2, 3, 4, 4, 4)
        LogUtil.i("set-xxx", "set size = ${set1.size}")

        var m_set = mutableSetOf<Int>()
        m_set.add(1)
        m_set.add(1)
        m_set.add(2)
        for (v in m_set) {
            LogUtil.i("set-xxx", "set v = $v")
        }

        var m_set1 = HashSet<Int>()
        m_set1.add(1)
    }
}
