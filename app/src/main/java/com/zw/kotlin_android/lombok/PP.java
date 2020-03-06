package com.zw.kotlin_android.lombok;

import lombok.experimental.SuperBuilder;
// 可以包含父类的属性
public class PP extends P {
    public String tag;

    public PP(String name, int age, String tag) {
        super(name, age);
        this.tag = tag;
    }

    public void sys() {

    }
}
