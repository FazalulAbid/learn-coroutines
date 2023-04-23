package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "SuspendFunction"

private fun learnSuspendFunction() {
    GlobalScope.launch {
        // Delay is a suspend function.
        // It can only be called inside another suspend function or inside a coroutine.
        val networkCallAnswer1 = doNetworkCall()
        val networkCallAnswer2 = doNetworkCall2()
        Log.d(TAG, networkCallAnswer1)
        Log.d(TAG, networkCallAnswer2)
        delay(1000L)
    }
}

private suspend fun doNetworkCall(): String {
    delay(3000L)
    return "This is the answer"
}

private suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "This is the answer"
}