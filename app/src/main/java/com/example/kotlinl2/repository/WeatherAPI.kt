package com.example.kotlinl2.repository

import com.example.kotlinl2.model.WeatherDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherAPI {
    @GET("v2/informer")
    fun getWeather(
        @Header("X-Yandex-API-Key") token: String,
        @Query("lat") lat : Double,
        @Query("lon") lon : Double

    ) : Call<WeatherDTO>
    }
