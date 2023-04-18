package com.fifty.learncoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

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

    private fun something() = runBlocking {
        launch {
            delay(1000L)
            Toast.makeText(this@MainActivity, "World", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

}