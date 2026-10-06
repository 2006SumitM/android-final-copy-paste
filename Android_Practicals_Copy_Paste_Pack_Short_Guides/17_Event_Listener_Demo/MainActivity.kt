package com.example.myapplication

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnClick)
        val message = findViewById<TextView>(R.id.tvMessage)
        val name = findViewById<EditText>(R.id.etName)
        val image = findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
            Toast.makeText(
                this,
                "Button Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        message.setOnLongClickListener {
            Toast.makeText(
                this,
                "Long Click",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        name.setOnFocusChangeListener { _, hasFocus ->
            val text =
                if (hasFocus) "Focus Received"
                else "Focus Lost"

            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }

        image.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                view.performClick()

                Toast.makeText(
                    this,
                    "Image Touched",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
    }
}
