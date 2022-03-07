package com.example.kotlinl2.repository

import com.example.kotlinl2.BuildConfig
import com.example.kotlinl2.model.WeatherDTO
import com.google.gson.GsonBuilder
import okhttp3.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val REQUEST_API_KEY = "X-Yandex-API-Key"

class RemoteDataSource {

    private val weatherAPI = Retrofit.Builder()
        .baseUrl("https://api.weather.yandex.ru/")
        .addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setLenient().create())
        ).build().create(WeatherAPI::class.java)

    fun getWeatherDetails(lat: Double, lon: Double, callback: retrofit2.Callback<WeatherDTO>) {
        weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY, lat, lon).enqueue(callback)
    }

   fun getWeatherDetails(requestLink: String, callback: Callback) {
//        val builder: Request.Builder = Request.Builder().apply {
//            header(REQUEST_API_KEY, BuildConfig.WEATHER_API_KEY)
//            url(requestLink)
//        }
//
//        OkHttpClient().newCall(builder.build()).enqueue(callback)
 }
}