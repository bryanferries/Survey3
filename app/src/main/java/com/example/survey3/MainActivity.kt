package com.example.survey3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


const val EXTRA_COUNT_VALUE = "com.example.survey3.COUNT_DISPLAY_VALUE"


class MainActivity : AppCompatActivity() {

    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(this).get(SurveyViewModel::class.java)
    }

    private lateinit var addButton: Button
    private lateinit var resultsButton: Button
    private lateinit var countDisplay: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.add_button)
        resultsButton = findViewById(R.id.results_button)
        countDisplay = findViewById(R.id.count_textview)

        addButton.setOnClickListener {
            addToCount()
        }

        resultsButton.setOnClickListener {
            showResults()
        }
    }

    private fun addToCount() {
        surveyViewModel.addToCount()
        updateCount()
    }

    private fun updateCount() {
        val countToDisplay = surveyViewModel.getCount()
        val countDisplayed = countToDisplay.toString()
        countDisplay.text = countDisplayed
    }

    private fun showResults() {
        val showResultsIntent = Intent(this, SurveyResultActivity::class.java)

        showResultsIntent.putExtra(EXTRA_COUNT_VALUE, countDisplay.text)

        startActivity(showResultsIntent)
    }
}