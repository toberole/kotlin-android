package com.zw.kotlin_android.demo1;

import com.zw.kotlin_android.utils.LogUtil;

public class Hello {
    public static final String TAG = Hello.class.getSimpleName();
    public String s;

    public Hello(String s) {
        this.s = s;
    }

    public <T> void test(T ddd) {
        LogUtil.Companion.i(TAG, String.valueOf(ddd));
    }

    public void sys() {
        LogUtil.Companion.i(TAG, "sys ......");
    }
}
