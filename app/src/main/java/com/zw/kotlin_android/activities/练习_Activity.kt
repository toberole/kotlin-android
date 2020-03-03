package com.zw.kotlin_android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zw.kotlin_android.R
import com.zw.kotlin_android.demo1.TokenRequest
import com.zw.kotlin_android.demo1.TokenRequest1
import com.zw.kotlin_android.demo1.TokenRequestCallback
import com.zw.kotlin_android.utils.LogUtil
import kotlinx.android.synthetic.main.activity_lianxi.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class 练习_Activity : AppCompatActivity(), View.OnClickListener {
    var TAG = 练习_Activity::class.java.simpleName + "_xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lianxi)

        btn_token.setOnClickListener(this)
        btn_token1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_token -> {
                test1()
            }
            R.id.btn_token1 -> {
                test2()
            }
        }
    }

    /*
        传统回调
     */
    private fun test1() {
        var reuqest = TokenRequest("", object : TokenRequestCallback {
            override fun onError(errorCode: Int, errorMsg: String) {
                LogUtil.i(TAG, "errorCode: $errorCode,errorMsg: $errorMsg")
            }

            override fun onSuccess(res: String) {
                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(this@练习_Activity, res, Toast.LENGTH_SHORT).show()
                }
            }
        })

        reuqest.getToken()
    }

    /*
        高阶函数代替回调
     */
    private fun test2() {
        var request = TokenRequest1("", { errorCode: Int, errorMsg: String ->
            LogUtil.i(TAG, "errorCode: $errorCode,errorMsg: $errorMsg")
        }, { res: String ->
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(this@练习_Activity, res, Toast.LENGTH_SHORT).show()
            }
        })

        request.getToken()
    }
}
