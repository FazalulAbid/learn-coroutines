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
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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