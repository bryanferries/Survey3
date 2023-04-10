package com.example.survey3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val EXTRA_PALESTINIAN_COUNT = "com.example.survey3.PALESTINIAN_COUNT"
const val EXTRA_COUNT_VALUE = "com.example.survey3.COUNT_DISPLAY_VALUE"

class MainActivity : AppCompatActivity() {

    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(this).get(SurveyViewModel::class.java)
    }

    private var israeliCountReturned = 0
    private var palestinianCountReturned = 0
    private lateinit var addPalestinian: Button
    private lateinit var addIsraeli: Button
    private lateinit var resultButton: Button
    private lateinit var israeliCount: TextView
    private lateinit var palestinianCount: TextView
                                                                    // Declare the variables for the extra keys and values, the view model, and the layout components
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addIsraeli = findViewById(R.id.israeli_button)
        addPalestinian = findViewById(R.id.palestinian_button)
        israeliCount = findViewById(R.id.israeli_count)
        palestinianCount = findViewById(R.id.palestinian_count)
        resultButton = findViewById(R.id.results_button)
                                                                                                    // Instantiate variables for the views and intents
        palestinianCountReturned = intent.getIntExtra(EXTRA_PALESTINIAN_FROM_RESULT, 0)
        israeliCountReturned = intent.getIntExtra(EXTRA_ISRAELI_FROM_RESULT, 0)

        palestinianCount.text = palestinianCountReturned.toString()
        israeliCount.text = israeliCountReturned.toString()
                                                                        // Set the text views to display the strings for each ocount

        addPalestinian.setOnClickListener {
            addPalestinian()
        }

        addIsraeli.setOnClickListener {
            addIsraeli()
        }
                                                            // Make click listeners for the voting and result buttons
        resultButton.setOnClickListener {
            showResults()
        }
    }

    private fun addIsraeli() {
        surveyViewModel.addIsraeli()
        updateCount()
    }
                                                // Make functions to vote using a view model and also calling the updateCount function
    private fun addPalestinian() {
        surveyViewModel.addPalestinian()
        updateCount()
    }

    private fun updateCount() {
        val palestinianCountInt = palestinianCountReturned + surveyViewModel.getPalestinian()
        val palestinianCountString = palestinianCountInt.toString()
        palestinianCount.text = palestinianCountString
                                                                                        // Add the get functions from the ViewModel to the Extra int from the results activity
        val israeliCountInt = israeliCountReturned + surveyViewModel.getIsraeli()
        val israeliCountString = israeliCountInt.toString()
        israeliCount.text = israeliCountString
    }
                                                                                                                                // Intent with each count as an Extra
    private fun showResults() {
        val showResultsIntent = Intent(this, SurveyResultActivity::class.java)
        showResultsIntent.putExtra(EXTRA_COUNT_VALUE, israeliCountReturned + surveyViewModel.getIsraeli())
        showResultsIntent.putExtra(EXTRA_PALESTINIAN_COUNT, palestinianCountReturned + surveyViewModel.getPalestinian())
        startActivity(showResultsIntent)
    }
}