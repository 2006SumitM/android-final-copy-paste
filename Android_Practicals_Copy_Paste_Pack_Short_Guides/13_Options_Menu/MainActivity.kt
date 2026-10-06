package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = when (item.itemId) {
            R.id.menuSearch -> "Search clicked"
            R.id.menuSettings -> "Settings clicked"
            R.id.menuAbout -> "About clicked"
            else -> return super.onOptionsItemSelected(item)
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        return true
    }
}
