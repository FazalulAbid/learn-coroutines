package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.*

suspend fun learnJobs() {
    // Also sometime we need to check if we are doing big tasks, if the coroutine is still active or not.
    val job = GlobalScope.launch(Dispatchers.Default) {
        Log.d(TAG, "learnJobs: Starting long running calculation.")
        // Also we can use with timeout, for something like network requests.
        // if this need more than 3 seconds it will cancel automatically.
        withTimeout(3000L) {
            for (i in 30..40) {
                if (isActive)
                    Log.d(TAG, "learnJobs: Result for i = $i: ${fibonacci(i)}")
            }
        }
        Log.d(TAG, "learnJobs: Ending long running calculation...")
    }

    runBlocking {
//        // Wait until the job completes.
//        job.join()
//        // Also we can cancel a job.
        delay(2000L)
        job.cancel()
        Log.d(TAG, "onCreate: Canceled job!")
    }
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
}