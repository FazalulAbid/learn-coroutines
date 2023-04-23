package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val RunBlockingTag = "RunBlocking"

suspend fun learnRunBlocking() {
    // Run blocking can block the main thread.
    // If we use delay in GlobalScope we can still use the UI if we call a delay.
    // But when we use run blocking we can block the main thread
    // It is useful when we need the coroutine behavior and need to block the main thread, like calling a suspend function.
    Log.d(RunBlockingTag, "learnRunBlocking: Before runBlocking")
    runBlocking {
        // This launch block will not block the main thread.
        launch {
            delay(3000L)
            Log.d(RunBlockingTag, "learnRunBlocking: Finished IO Coroutine 1")
        }
        launch {
            delay(3000L)
            Log.d(RunBlockingTag, "learnRunBlocking: Finished IO Coroutine 2")
        }
        Log.d(RunBlockingTag, "learnRunBlocking: Start of runBlocking")
        delay(5000L)
        Log.d(RunBlockingTag, "learnRunBlocking: End of runBlocking")
    }
    Log.d(RunBlockingTag, "learnRunBlocking: After runBlocking")

}