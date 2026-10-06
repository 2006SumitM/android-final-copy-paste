package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fname = findViewById<EditText>(R.id.etFirstName)
        val lname = findViewById<EditText>(R.id.etLastName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val email = findViewById<EditText>(R.id.etEmail)

        val register = findViewById<Button>(R.id.btnRegister)
        val reset = findViewById<Button>(R.id.btnReset)

        register.setOnClickListener {
            if (fname.text.toString().isNotEmpty() &&
                phone.text.toString().isNotEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Registered Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Please Enter Details",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        reset.setOnClickListener {
            fname.text.clear()
            lname.text.clear()
            phone.text.clear()
            email.text.clear()
        }
    }
}
