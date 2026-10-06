package com.example.myapplication

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageView)
        val text = findViewById<TextView>(R.id.tvPopup)

        registerForContextMenu(image)

        text.setOnClickListener {
            val popup = PopupMenu(this, text)
            popup.menuInflater.inflate(
                R.menu.popup_menu,
                popup.menu
            )

            popup.setOnMenuItemClickListener { item ->
                val message = when (item.itemId) {
                    R.id.menuCut -> "Cut"
                    R.id.menuCopy -> "Copy"
                    R.id.menuPaste -> "Paste"
                    else -> return@setOnMenuItemClickListener false
                }

                Toast.makeText(
                    this,
                    message,
                    Toast.LENGTH_SHORT
                ).show()

                true
            }

            popup.show()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        view: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, view, menuInfo)

        menuInflater.inflate(
            R.menu.context_menu,
            menu
        )

        menu.setHeaderTitle("Select Option")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuShare ->
                Toast.makeText(
                    this,
                    "Image Shared",
                    Toast.LENGTH_SHORT
                ).show()

            R.id.menuSave ->
                Toast.makeText(
                    this,
                    "Image Saved",
                    Toast.LENGTH_SHORT
                ).show()

            else -> return super.onContextItemSelected(item)
        }

        return true
    }
}
