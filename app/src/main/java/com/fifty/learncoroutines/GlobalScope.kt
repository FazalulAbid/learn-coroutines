package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private fun learnGlobalScope() {
    // Every coroutine does need a coroutine scope to work.
    // Global scope means, this coroutine will live as long the application does.
    // But of course it will die if it finishes its job.
    GlobalScope.launch {
        delay(3000L)
        Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
    }
    Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")
}