package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "ActivityLifecycle"

    private fun show(name: String) {
        Log.d(TAG, "$name Called")
        findViewById<TextView>(R.id.tvStatus)?.text = "$name Called"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show("onCreate")
    }

    override fun onStart() {
        super.onStart()
        show("onStart")
    }

    override fun onResume() {
        super.onResume()
        show("onResume")
    }

    override fun onPause() {
        show("onPause")
        super.onPause()
    }

    override fun onStop() {
        show("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy Called")
        super.onDestroy()
    }
}
