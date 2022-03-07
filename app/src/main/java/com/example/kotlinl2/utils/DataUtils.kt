package com.example.kotlinl2.utils

import com.example.kotlinl2.model.FactDTO
import com.example.kotlinl2.model.Weather
import com.example.kotlinl2.model.WeatherDTO
import com.example.kotlinl2.model.getDefaultCity

fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact : FactDTO = weatherDTO.fact!! // !! - не надо так ( -_-)
    return listOf(Weather(getDefaultCity(), fact.temp!!, fact.feels_like!!, fact.condition!!))


}