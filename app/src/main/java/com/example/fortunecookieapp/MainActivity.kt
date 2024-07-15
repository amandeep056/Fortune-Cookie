package com.example.fortunecookieapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCategory: Spinner
    private lateinit var buttonGenerate: Button
    private lateinit var textViewFortune: TextView

    private val fortunesLove = arrayOf(
        "You will find love soon.",
        "Someone is thinking about you.",
        "Your romantic life will flourish."
    )

    private val fortunesCareer = arrayOf(
        "Success is on the horizon.",
        "A new opportunity awaits.",
        "Hard work will pay off soon."
    )

    private val fortunesHealth = arrayOf(
        "You will enjoy good health.",
        "Take care of your body and it will take care of you.",
        "A healthy mind resides in a healthy body."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCategory = findViewById(R.id.spinnerCategory)
        buttonGenerate = findViewById(R.id.buttonGenerate)
        textViewFortune = findViewById(R.id.textViewFortune)

        val categories = resources.getStringArray(R.array.categories)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        buttonGenerate.setOnClickListener {
            val selectedCategory = spinnerCategory.selectedItem.toString()
            val fortune = generateFortune(selectedCategory)
            textViewFortune.text = fortune
        }
    }

    private fun generateFortune(category: String): String {
        return when (category) {
            "Love" -> fortunesLove.random()
            "Career" -> fortunesCareer.random()
            "Health" -> fortunesHealth.random()
            else -> "Good things are coming your way."
        }
    }
}
