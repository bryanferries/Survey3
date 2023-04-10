package com.example.survey3

import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {

    private var israeliCount = 0
    private var palestinianCount = 0
                                                // Make int variables to hold the data for each count
    fun addIsraeli() {
        israeliCount++
    }

    fun getIsraeli(): Int {
        return israeliCount
    }
                                                // Make the functions to add one to each count variable or return the int
    fun addPalestinian() {
        palestinianCount++
    }

    fun getPalestinian(): Int {
        return palestinianCount
    }
}