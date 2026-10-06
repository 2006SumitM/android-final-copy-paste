package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            if (username.text.toString() == "admin" &&
                password.text.toString() == "1234"
            ) {
                val intent = Intent(
                    this,
                    SecondActivity::class.java
                )

                intent.putExtra(
                    "Name",
                    username.text.toString()
                )

                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Invalid Username or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com")
                    )
                )
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "No browser found",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        findViewById<Button>(R.id.btnContact).setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:1234567890")
                    )
                )
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "No dialer found",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
