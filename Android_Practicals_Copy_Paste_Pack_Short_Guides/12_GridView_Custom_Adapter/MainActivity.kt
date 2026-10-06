package com.example.myapplication

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid = findViewById<GridView>(R.id.gridItems)

        val names = arrayOf(
            "Android",
            "Kotlin",
            "Java",
            "Python",
            "HTML",
            "CSS"
        )

        grid.adapter = CustomAdapter(this, names)

        grid.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Selected: ${names[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
