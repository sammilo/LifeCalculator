package com.example.lifecalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputAge = findViewById<EditText>(R.id.inputAge)
        val calculateBtn = findViewById<Button>(R.id.calculateButton)
        val weeks = findViewById<TextView>(R.id.weeks)

        calculateBtn.setOnClickListener {
            val ageStr = inputAge.text.toString()
            if (ageStr.isNotEmpty()) {
                val age = ageStr.toInt()
                val weeksLeft = calcWeeksLeft(age)
                weeks.text = "$weeksLeft"
            }
        }
    }

    private fun calcWeeksLeft(age: Int): Int {
        val output = 4000 - (age * 52)
        if (output < 0) {
            return 0
        }
        return output
    }
}