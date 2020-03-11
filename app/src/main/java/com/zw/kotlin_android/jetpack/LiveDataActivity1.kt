package com.zw.kotlin_android.jetpack

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.zw.kotlin_android.R
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_live_data1.*


class LiveDataActivity1 : AppCompatActivity(), View.OnClickListener {
    private var TAG = "ld-xxx"

    private lateinit var nameModel: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data1)

        btn_ld1.setOnClickListener(this)
        btn_ld2.setOnClickListener(this)

        init()
    }

    fun init() {
        nameModel = ViewModelProvider.AndroidViewModelFactory(this.application).create(NameViewModel::class.java)
        nameModel.getCurrentName().observe(this, Observer {
            LogUtil.i(TAG, "name: $it")
        })

        nameModel.getNames().observe(this, Observer {
            for (str in it) {
                LogUtil.i(TAG, "str: $str")
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_ld1 -> {
                nameModel.getCurrentName().postValue("计算机技术")
            }
            R.id.btn_ld2 -> {
                nameModel.getNames().postValue(listOf("1", "2"))
            }
        }
    }
}
