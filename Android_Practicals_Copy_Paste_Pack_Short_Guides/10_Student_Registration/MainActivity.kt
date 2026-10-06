package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val contact = findViewById<EditText>(R.id.etContact)
        val address = findViewById<EditText>(R.id.etAddress)
        val city = findViewById<EditText>(R.id.etCity)
        val state = findViewById<EditText>(R.id.etState)
        val country = findViewById<EditText>(R.id.etCountry)
        val qualification =
            findViewById<EditText>(R.id.etQualification)
        val skills = findViewById<EditText>(R.id.etSkills)

        val gender = findViewById<RadioGroup>(R.id.rgGender)
        val dancing = findViewById<CheckBox>(R.id.cbDancing)
        val singing = findViewById<CheckBox>(R.id.cbSinging)
        val reading = findViewById<CheckBox>(R.id.cbReading)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

            if (name.text.toString().trim().isEmpty()) {
                name.error = "Name is required"
                name.requestFocus()
                return@setOnClickListener
            }

            if (gender.checkedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select a gender",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val selectedGender =
                findViewById<RadioButton>(
                    gender.checkedRadioButtonId
                ).text.toString()

            val hobbies = mutableListOf<String>()

            if (dancing.isChecked) hobbies.add("Dancing")
            if (singing.isChecked) hobbies.add("Singing")
            if (reading.isChecked) hobbies.add("Reading")

            val hobbyText =
                if (hobbies.isEmpty()) "None"
                else hobbies.joinToString(", ")

            Toast.makeText(
                this,
                "Registration Successful!\n" +
                    "Name: ${name.text}\n" +
                    "Gender: $selectedGender\n" +
                    "Hobbies: $hobbyText",
                Toast.LENGTH_LONG
            ).show()
        }

        findViewById<Button>(R.id.btnReset).setOnClickListener {
            listOf(
                name, email, contact, address, city,
                state, country, qualification, skills
            ).forEach { it.text.clear() }

            gender.clearCheck()
            dancing.isChecked = false
            singing.isChecked = false
            reading.isChecked = false
        }
    }
}
