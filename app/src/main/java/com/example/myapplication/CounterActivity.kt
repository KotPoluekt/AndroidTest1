package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        var counter = intent.getIntExtra(MainActivity.EXTRA_COUNTER, -1)

        findViewById<TextView>(R.id.text1).setText("Counter = $counter")

        findViewById<Button>(R.id.buttonDecrease).setOnClickListener {
            counter--
            counter--
            findViewById<TextView>(R.id.text1).setText("Counter = $counter")

            val data = Intent()
            data.putExtra(MainActivity.EXTRA_COUNTER, counter)
            setResult(RESULT_OK, data)
        }

        findViewById<Button>(R.id.buttonDecreaseAndClose).setOnClickListener {
            counter--
            counter--
            findViewById<TextView>(R.id.text1).setText("Counter = $counter")

            val data = Intent()
            data.putExtra(MainActivity.EXTRA_COUNTER, counter)
            setResult(RESULT_OK, data)
            finish()
        }

        Log.d("TEST1. CounterActivity", "onCreate" )

    }

    override fun onStart() {
        super.onStart()
        Log.d("TEST1. CounterActivity", "onStart" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST1. CounterActivity", "onResume" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("TEST1. CounterActivity", "onPause" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("TEST1. CounterActivity", "onStop" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TEST1. CounterActivity", "onDestroy" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TEST1. CounterActivity", "onRestart" )
    }
}