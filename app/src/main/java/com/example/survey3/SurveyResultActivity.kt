package com.example.survey3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class SurveyResultActivity : AppCompatActivity() {

    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(this).get(SurveyViewModel::class.java)
    }

    private lateinit var countFromMain: TextView
    private lateinit var countFromModel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)

        countFromMain = findViewById(R.id.count_from_main)
        countFromModel = findViewById(R.id.results_count)

        val countValue = intent.getIntExtra(EXTRA_COUNT_VALUE, 100)

        countFromMain.text = countValue.toString()
        countFromModel.text = surveyViewModel.getCount().toString()
    }
}