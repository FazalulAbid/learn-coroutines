package com.fifty.learncoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    private fun something() = runBlocking {
        launch {
            delay(1000L)
            Toast.makeText(this@MainActivity, "World", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

}