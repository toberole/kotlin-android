package com.zw.kotlin_android.demo1

class Student4 {
    var age: Int = 0
    var age1: Int = 0

    constructor(age: Int) {
        this.age = age
    }

    constructor(age: Int, age1: Int) : this(age) {
        this.age1 = age1
    }

    override fun toString(): String {
        return "Student4(age=$age, age1=$age1)"
    }
}