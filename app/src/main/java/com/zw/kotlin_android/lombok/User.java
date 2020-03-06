package com.zw.kotlin_android.lombok;

import com.zw.kotlin_android.utils.LogUtil;

import lombok.Builder;

public class User {
    public String name = "hello";
    public int age;

    // 忽略掉age
    @Builder
    private User(String name) {
        this.name = name;
        LogUtil.Companion.i("xxx", "name: " + name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
