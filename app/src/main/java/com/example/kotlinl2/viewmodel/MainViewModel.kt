package com.example.kotlinl2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinl2.model.Repository
import com.example.kotlinl2.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel (

    private val liveDataToObserve : MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl())
    : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()


    private fun getDataFromLocalSource(){
        liveDataToObserve.value = AppState.Loading
        Thread{
            sleep(2000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromServer()))
        }.start()
    }
}