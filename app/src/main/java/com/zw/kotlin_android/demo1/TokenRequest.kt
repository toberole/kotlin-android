package com.zw.kotlin_android.demo1

import com.zw.kotlin_android.utils.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class TokenRequest(var url: String, var callback: TokenRequestCallback) {
    var TAG = TokenRequest::class.java.simpleName

    fun getToken() {
        GlobalScope.launch(Dispatchers.IO) {
            delay(1000)
            LogUtil.i(TAG, "url ...... $url")

            callback?.onError(-1, "error test")
            callback?.onSuccess("success " + System.currentTimeMillis())
        }
    }
}

class TokenRequest1(var url: String, var error_cb: (Int, String) -> Unit, var success_cb: (String) -> Unit) {
    fun getToken() {
        GlobalScope.launch(Dispatchers.IO) {
            delay(2000)
            error_cb?.invoke(-1, "lambda error ......")
            success_cb?.invoke("lambda success ......")
        }
    }
}