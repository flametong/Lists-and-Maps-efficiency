package com.example.listsandmapsefficiency.util

import android.util.Log
import com.example.listsandmapsefficiency.interfaces.Logger

class LoggerImpl : Logger {

    override fun logD(tag: String?, message: String) {
        Log.d(tag, message)
    }

    override fun logE(tag: String?, message: String) {
        Log.e(tag, message)
    }
}