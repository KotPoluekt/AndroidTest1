package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

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

        // новый подход
        val startAnotherActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { res ->
            val data = res.data
            if (res.resultCode == RESULT_OK && data != null ) {
                counter = data.getIntExtra(EXTRA_COUNTER, -1)
                input.setText("Counter = $counter")
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "It's bad. BAD!!!!", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.buttonNewActivity).setOnClickListener {
            // старый подход
            val intent = Intent(this, CounterActivity::class.java)
            intent.putExtra(EXTRA_COUNTER, counter)
//            startActivityForResult(intent, REQUEST_CODE)

            // новый подход
            startAnotherActivity.launch(intent)
        }

        findViewById<Button>(R.id.buttonOpenSite).setOnClickListener {
            //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://mail.ru/"))
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:121212"))
            startActivity(intent)
        }

        Log.d("TEST1. Main", "onCreate " )
        Log.d("TEST1. Main", if (savedInstanceState == null) "New activity" else "Existing activity" )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_COUNTER, counter)

        Log.d("TEST1. Main", "onSaveInstanceState " )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter = savedInstanceState?.getInt(EXTRA_COUNTER, 0 ) ?: 0
        input.setText("Counter = $counter")

        Log.d("TEST1. Main", "onRestoreInstanceState " )
    }

    override fun onStart() {
        super.onStart()
        Log.d("TEST1. Main", "onStart" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST1. Main", "onResume" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("TEST1. Main", "onPause" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("TEST1. Main", "onStop" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TEST1. Main", "onDestroy" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TEST1. Main", "onRestart" )
    }

    companion object {
        const val EXTRA_COUNTER = "counter"
        const val REQUEST_CODE = 1000
    }

    // старый подход
//     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//         Log.d("TEST1. Main", "onActivityResult" )
//        if (requestCode == REQUEST_CODE) {
//            if (resultCode == RESULT_OK && data != null ) {
//                counter = data.getIntExtra(EXTRA_COUNTER, -1)
//                input.setText("Counter = $counter")
//                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "It's bad. BAD!!!!", Toast.LENGTH_SHORT).show()
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
}