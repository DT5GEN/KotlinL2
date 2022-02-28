package com.example.kotlinl2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinl2.model.Repository
import com.example.kotlinl2.model.RepositoryImpl
import com.example.kotlinl2.viewmodel.AppState
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve : MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
)
    : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld()  = getDataFromLocalSource(isRussian = false)

    private fun getDataFromLocalSource(isRussian : Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(2000)
            liveDataToObserve.postValue(
                AppState.Success(
                if (isRussian)
                    repositoryImpl.getWeatherFromLocalStorageRus()
                else
                    repositoryImpl.getWeatherFromLocalStorageWorld()))
        }.start()
    }
}