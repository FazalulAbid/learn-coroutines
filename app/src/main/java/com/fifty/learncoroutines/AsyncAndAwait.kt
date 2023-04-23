package com.fifty.learncoroutines

import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun learnAwait() {
    // Here we are doing two network calls at the same time.
    // We do each one in different launch blocks.
    // So it will work together.
    // But this is not the approach to do that.
    // We should use async.
    GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            var answer1: String? = null
            var answer2: String? = null
            val job1 = launch { answer1 = networkCall1() }
            val job2 = launch { answer2 = networkCall2() }
            // And here we wait for the two jobs to get finished.
            // So it will take only 3 seconds totally.
            job1.join()
            job2.join()
            Log.d(TAG, "onCreate: Answer 1 is $answer1")
            Log.d(TAG, "onCreate: Answer 2 is $answer2")
        }
        Log.d(TAG, "onCreate: Request took $time ms.")
    }
}

suspend fun learnAsync() {
    GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            // This returns a differed string.
            val answer1 = async { networkCall1() }
            val answer2 = async { networkCall2() }
            // As it is a differed string, we can call await method,
            // so it work when the value is available.
            Log.d(TAG, "onCreate: Answer 1 is ${answer1.await()}")
            Log.d(TAG, "onCreate: Answer 2 is ${answer2.await()}")
        }
        Log.d(TAG, "onCreate: Request took $time ms.")
    }
}

suspend fun networkCall1(): String {
    delay(3000L)
    return "Answer 1"
}

suspend fun networkCall2(): String {
    delay(3000L)
    return "Answer 2"
}