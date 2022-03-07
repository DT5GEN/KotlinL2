package com.example.kotlinl2.repository

import okhttp3.Callback

interface DetailsRepository {

    fun getWeatherDetailsFromServer(requestLink: String, callback: Callback)
}