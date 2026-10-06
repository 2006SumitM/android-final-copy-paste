package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uname = findViewById<EditText>(R.id.etUsername)
        val pwd = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            if (uname.text.toString() == "admin" &&
                pwd.text.toString() == "1234"
            ) {
                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Invalid Username or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            Toast.makeText(
                this,
                "Visit college website to register",
                Toast.LENGTH_SHORT
            ).show()
        }

        findViewById<TextView>(R.id.tvForgot).setOnClickListener {
            Toast.makeText(
                this,
                "Check your email to reset password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
