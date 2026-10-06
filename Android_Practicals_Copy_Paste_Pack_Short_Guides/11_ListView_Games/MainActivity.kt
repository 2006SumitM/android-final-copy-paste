package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<ListView>(R.id.listGames)
        val selected = findViewById<TextView>(R.id.tvSelected)

        val games = arrayOf(
            "Cricket",
            "Football",
            "Hockey",
            "Basketball",
            "Tennis"
        )

        list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            games
        )

        list.setOnItemClickListener { _, _, position, _ ->
            selected.text = "Selected Item: ${games[position]}"
        }
    }
}
