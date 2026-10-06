package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var firstImage = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnChange)
        val img = findViewById<ImageView>(R.id.imageView)

        btn.setOnClickListener {
            if (firstImage) {
                img.setImageResource(android.R.drawable.ic_menu_camera)
            } else {
                img.setImageResource(android.R.drawable.ic_menu_gallery)
            }
            firstImage = !firstImage
        }
    }
}
