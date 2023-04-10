package com.example.survey3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_PALESTINIAN_FROM_RESULT = "com.example.survey3.PALESTINIAN_RESULT"
const val EXTRA_ISRAELI_FROM_RESULT = "com.example.survey3.RESULT_COUNT"

class SurveyResultActivity : AppCompatActivity() {
                                                                // Declare all the variables for views, ints of the counts, and keys for extras
    private var palestinianCountInt = 0
    private var israeliCountInt = 0
    private lateinit var palestinianCountView: TextView
    private lateinit var israeliCountView: TextView
    private lateinit var continueSurveyButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)

        continueSurveyButton = findViewById(R.id.continue_survey_button)
        resetButton = findViewById(R.id.reset_button)
        israeliCountView = findViewById(R.id.israeli_count_result)
        palestinianCountView = findViewById(R.id.palestinian_count_result)
                                                                                            // Instantiate the component variables
        palestinianCountInt = intent.getIntExtra(EXTRA_PALESTINIAN_COUNT, 100)
        israeliCountInt = intent.getIntExtra(EXTRA_COUNT_VALUE, 100)
        palestinianCountView.text = palestinianCountInt.toString()
        israeliCountView.text = israeliCountInt.toString()
                                                                    // Make click listeners for the reset and continue survey buttons
        resetButton.setOnClickListener {
            reset()
        }
                                                                            
        continueSurveyButton.setOnClickListener {
            returnToSurvey()
        }
    }
                                                                            // Reset the count by setting the TextViews equal to 0
    private fun reset() {
        palestinianCountInt = 0
        palestinianCountView.text = palestinianCountInt.toString()
        israeliCountInt = 0
        israeliCountView.text = israeliCountInt.toString()
    }
                                                                                        // Return to survey with the current count using intents and extras
    private fun returnToSurvey() {
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        mainActivityIntent.putExtra(EXTRA_ISRAELI_FROM_RESULT, israeliCountInt)
        mainActivityIntent.putExtra(EXTRA_PALESTINIAN_FROM_RESULT, palestinianCountInt)
        startActivity(mainActivityIntent)
    }
}