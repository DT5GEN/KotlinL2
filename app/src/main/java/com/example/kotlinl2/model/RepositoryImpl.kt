package com.example.kotlinl2.model

class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
      //  TODO("Not yet implemented")
        return Weather()
    }

    override fun getWeatherFromLocalStorage(): Weather {
     //   TODO("Not yet implemented")
        return Weather ()
    }
}