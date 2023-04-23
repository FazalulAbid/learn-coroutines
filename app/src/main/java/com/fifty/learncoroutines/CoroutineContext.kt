package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun learnCoroutineContext() {
    // We cannot do a network call on the main thread, as it blocks the main thread and UI.
    GlobalScope.launch(Dispatchers.IO) {
        Log.d(
            TAG,
            "learnCoroutineContext: Starting coroutine in thread ${Thread.currentThread().name}"
        )
        val answer = doNetworkCall()
        // After the network call we change the context of the coroutine to Main thread.
        // As we can only change the UI from the main thread.
        withContext(Dispatchers.Main) {
            Log.d(
                TAG,
                "learnCoroutineContext: updating the UI in thread ${Thread.currentThread().name}"
            )
            // Update the UI from
        }
    }
}