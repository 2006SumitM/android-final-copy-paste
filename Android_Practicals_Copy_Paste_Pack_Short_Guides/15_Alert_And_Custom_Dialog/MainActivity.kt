package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAlert).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("Do you want to save?")
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(
                        this,
                        "Saved",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton("No", null)
                .show()
        }

        findViewById<Button>(R.id.btnCustom).setOnClickListener {
            val view = LayoutInflater.from(this)
                .inflate(R.layout.custom_dialog, null)

            val dialog = AlertDialog.Builder(this)
                .setView(view)
                .create()

            val name = view.findViewById<EditText>(R.id.etName)

            view.findViewById<Button>(R.id.btnOk).setOnClickListener {
                Toast.makeText(
                    this,
                    "Hello ${name.text}",
                    Toast.LENGTH_SHORT
                ).show()

                dialog.dismiss()
            }

            dialog.show()
        }
    }
}
