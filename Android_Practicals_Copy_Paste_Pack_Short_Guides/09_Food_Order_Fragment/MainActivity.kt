package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity :
    AppCompatActivity(),
    OrderFragment.OnMessageSendListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = findViewById<EditText>(R.id.etItem)
        val qty = findViewById<EditText>(R.id.etQty)

        findViewById<Button>(R.id.btnPlace).setOnClickListener {
            val food = item.text.toString().trim()
            val quantity = qty.text.toString().trim()

            if (food.isEmpty() || quantity.isEmpty()) {
                findViewById<TextView>(R.id.tvResult).text =
                    "Enter item and quantity"
                return@setOnClickListener
            }

            val fragment = OrderFragment()
            fragment.arguments = Bundle().apply {
                putString("Food", food)
                putString("Qty", quantity)
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onMessageSend(message: String) {
        findViewById<TextView>(R.id.tvResult).text = message
        supportFragmentManager.popBackStack()
    }
}
