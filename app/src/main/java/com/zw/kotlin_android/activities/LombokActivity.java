package com.zw.kotlin_android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zw.kotlin_android.R;
import com.zw.kotlin_android.utils.LogUtil;

public class LombokActivity extends AppCompatActivity {

    public static final String TAG = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lombok2);

//        User user1 = User.builder().name("hhh").build();
//        User user2 = User.builder().build();
//
//        LogUtil.Companion.i(TAG, "user1: " + user1);
//        LogUtil.Companion.i(TAG, "user2: " + user2);
    }
}
