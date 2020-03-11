package com.zw.kotlin_android.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_live_data.*


class LiveDataActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = "livedata-xxx"

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

        LogUtil.i(TAG, "onCreate ......")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.i(TAG, "onStart ......")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.i(TAG, "onResume ......")
    }

    override fun onPause() {
        super.onPause()
        LogUtil.i(TAG, "onPause ......")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.i(TAG, "onStop ......")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.i(TAG, "onDestroy ......")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        LogUtil.i(TAG, "onNewIntent ......")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        LogUtil.i(TAG, "onSaveInstanceState ......")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtil.i(TAG, "onRestoreInstanceState ......")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_getUserInfo -> {
                userInfoViewModel.getUserInfo()
            }
        }
    }
}