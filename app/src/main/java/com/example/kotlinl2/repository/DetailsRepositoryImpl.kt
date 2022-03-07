package com.example.kotlinl2.repository

import okhttp3.Callback

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource): DetailsRepository {
    override fun getWeatherDetailsFromServer(requestLink: String, callback: Callback) {
        TODO("Not yet implemented")
    }
}