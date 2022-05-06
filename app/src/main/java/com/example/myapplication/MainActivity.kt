package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var counter = 0
    lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        input.setText("Counter = $counter")

        findViewById<Button>(R.id.button1).setOnClickListener {
             counter++
            input.setText("Counter = $counter")
        }

        Log.d("TEST1", "onCreate " )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        input.setText("Counter = $counter")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TEST1", "onStart" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST1", "onResume" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("TEST1", "onPause" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("TEST1", "onStop" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TEST1", "onDestroy" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TEST1", "onRestart" )
    }
}