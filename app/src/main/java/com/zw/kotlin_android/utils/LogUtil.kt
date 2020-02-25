package com.zw.kotlin_android.utils

import android.util.Log

class LogUtil {
    companion object {
        var debug = true

        fun v(tag: String, msg: String) {
            if (debug) {
                Log.v(tag, msg)
            }
        }

        fun i(tag: String, msg: String) {
            if (debug) {
                Log.i(tag, msg)
            }
        }

        fun w(tag: String, msg: String) {
            if (debug) {
                Log.w(tag, msg)
            }
        }

        fun e(tag: String, msg: String) {
            if (debug) {
                Log.e(tag, msg)
            }
        }
    }
}

