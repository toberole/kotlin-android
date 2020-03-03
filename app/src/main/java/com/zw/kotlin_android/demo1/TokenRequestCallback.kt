package com.zw.kotlin_android.demo1

interface TokenRequestCallback {
    fun onError(errorCode: Int, errorMsg: String)
    fun onSuccess(res: String)
}