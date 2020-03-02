package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil
import kotlin.reflect.KProperty


/*
    有一些常见的属性类型，虽然我们可以在每次需要的时候手动实现它们， 但是如果能够为大家把他们只实现
    一次并放入一个库会更好。例如包括：
        延迟属性（lazy properties）: 其值只在首次访问时计算；
        可观察属性（observable properties）: 监听器会收到有关此属性变更的通知；
        把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。
 */

/*
     val/var <属性名>: <类型> by <表达式>。在 by 后面的表达式是该 委托，
     因为属性对应的 get()（与 set()）会被委托给它的 getValue() 与 setValue() 方法。
     属性的委托不必实现任何的接口，但是需要提供一个 getValue() 函数（与 setValue()——对于 var 属性）。
 */

const val TAG = "Example-xxx"

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        LogUtil.i(TAG, "$value has been assigned to '${property.name}' in $thisRef.")
    }
}
