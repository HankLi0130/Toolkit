package app.hankdev.toolkit

import android.util.Log

object Log {
    var enable: Boolean = false

    private fun doWhenEnable(block: () -> Unit) {
        if (enable) block()
    }

    fun i(tag: String?, msg: String) = doWhenEnable {
        Log.i(tag, msg)
    }

    fun i(tag: String?, msg: String?, tr: Throwable?) = doWhenEnable {
        Log.i(tag, msg, tr)
    }

    fun e(tag: String?, msg: String) = doWhenEnable {
        Log.e(tag, msg)
    }

    fun e(tag: String?, msg: String?, tr: Throwable?) = doWhenEnable {
        Log.e(tag, msg, tr)
    }
}