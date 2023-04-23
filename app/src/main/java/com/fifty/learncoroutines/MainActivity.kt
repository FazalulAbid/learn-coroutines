package com.fifty.learncoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    suspend fun learnLifeCycleScope() {
        val button = findViewById<Button>(R.id.btnStartActivity)
        button.setOnClickListener {

            // If we do a work on the global scope, it has the life time as the application.
            // So if our activity get destroyed, the coroutine wont stop working,
            // This may cause memory leak as the garbage collector wont be able to find this.
            // So we use lifeCycleScope from lifeCycle.
            // It will be cancelled the coroutine when the activity is destroyed.
            // And there is anther scope called viewModelScope, it as same as this,
            // It will allow the coroutine to be alive as long as the viewModel is alive.
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "onCreate: Still running...")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}