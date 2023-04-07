package com.example.survey3

import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {

    private var count = 0

    fun addToCount() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}