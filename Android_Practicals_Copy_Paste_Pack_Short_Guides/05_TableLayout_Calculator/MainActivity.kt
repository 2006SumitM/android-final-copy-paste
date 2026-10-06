package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var firstNumber: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.tvDisplay)

        val nums = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        nums.forEach { id ->
            findViewById<Button>(id).setOnClickListener { view ->
                val n = (view as Button).text.toString()
                display.text =
                    if (display.text == "0") n
                    else display.text.toString() + n
            }
        }

        val ops = listOf(
            R.id.btnAdd, R.id.btnSub, R.id.btnMul,
            R.id.btnDiv, R.id.btnMod
        )

        ops.forEach { id ->
            findViewById<Button>(id).setOnClickListener { view ->
                firstNumber = display.text.toString().toDoubleOrNull()
                operator = (view as Button).text.toString()
                display.text = "0"
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            calculate()
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            display.text = "0"
            firstNumber = null
            operator = null
        }

        findViewById<Button>(R.id.btnDel).setOnClickListener {
            val t = display.text.toString()
            display.text = if (t.length <= 1) "0" else t.dropLast(1)
        }
    }

    private fun calculate() {
        val a = firstNumber ?: return
        val b = display.text.toString().toDoubleOrNull() ?: return

        val result = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) null else a / b
            "%" -> if (b == 0.0) null else a % b
            else -> null
        }

        display.text = when {
            result == null -> "Error"
            result % 1.0 == 0.0 -> result.toLong().toString()
            else -> result.toString()
        }

        firstNumber = null
        operator = null
    }
}
