package com.example.survey3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SurveyResultActivity : AppCompatActivity() {

    private lateinit var countFromMain: TextView
    private lateinit var countFromModel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)

        countFromMain = findViewById(R.id.count_from_main)
        countFromModel = findViewById(R.id.count_textview)

        val countValue = intent.getIntExtra(EXTRA_COUNT_VALUE, 100)

        countFromMain.text = countValue.toString()
        countFromModel.text =


    }
}