package com.zw.kotlin_android.jetpack

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zw.kotlin_android.R
import kotlinx.android.synthetic.main.activity_live_data.*


class LiveDataActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var userInfoViewModel: UserInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        // 创建ViewModel并将UI组件和LiveData进行绑定以便进行数据的更新
        userInfoViewModel = ViewModelProvider.NewInstanceFactory().create(UserInfoViewModel::class.java)
        userInfoViewModel.userData.observe(this, Observer {
            Toast.makeText(this@LiveDataActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })

        btn_getUserInfo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_getUserInfo -> {
                userInfoViewModel.getUserInfo()
            }
        }
    }
}