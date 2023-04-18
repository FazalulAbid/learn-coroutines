package com.fifty.learncoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        something()
    }

    private fun something() = runBlocking {
        launch {
            delay(1000L)
            Toast.makeText(this@MainActivity, "World", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

}