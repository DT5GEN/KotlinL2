package com.example.kotlinl2.viewmodel

import com.example.kotlinl2.model.Weather

sealed class AppState {

data class Success(val weatherData: Weather) : AppState()
data class Fail(val error: Throwable) : AppState()
object Loading: AppState()


}
