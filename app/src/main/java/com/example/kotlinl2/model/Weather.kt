package com.example.kotlinl2.model

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = -4,
    val feelsLike: Int = -2,
    val windSpeed: Int = 5,
    val pressure: Int = 742
)

fun getDefaultCity() = City("Урюпинск", 55.755826, 37.617299900000035)