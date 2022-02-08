package com.example.kotlinl2.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.kotlinl2.R
import com.example.kotlinl2.databinding.FragmentMainBinding
import com.example.kotlinl2.model.Weather
import com.example.kotlinl2.viewmodel.AppState
import com.example.kotlinl2.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private var fragmentMainBinding: FragmentMainBinding? = null
    private val binding get() = fragmentMainBinding!! // делаем геттер

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentMainBinding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        val observer = Observer<AppState> { renderData(it) }
//           val observer = object : Observer<Any> {
//               override fun onChanged(t: Any?) {
//                   TODO("Not yet implemented")
//               }
//           }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getWeatherFromRemoteSource()
    }

    private fun renderData(appState: AppState) {


        when (appState) {

            is AppState.Success -> {
                val weatherData = appState.weatherData
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView, "Success", Snackbar.LENGTH_LONG).show()
                setData(weatherData)
            }


            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Fail -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getWeatherFromRemoteSource() }
                    .show()
                // TODO dorabotat
            }

        }

    }
//
//    fun randomWeather(appState: AppState) {
//        val state = listOf(0, 1)
//        val randomIndex = Random.nextInt(state.size)
//        val randomElement = state[randomIndex]
//        if (randomElement == 1) {
//            successGo()
//        } else {
//            failGo()
//        }
//
//    }



    private fun setData(pogodaData: Weather) {

        binding.cityName.text = pogodaData.city.city
        binding.cityCoordinates.text = String.format(
            getString(R.string.city_coordinates),
            pogodaData.city.lat.toString(),
            pogodaData.city.lon.toString()
        )
        binding.temperatureValue.text = pogodaData.temperature.toString()
        binding.feelsLikeValue.text = pogodaData.feelsLike.toString()
        binding.pressureMm.text = pogodaData.pressure.toString()
        binding.windSpeed.text = pogodaData.windSpeed.toString()
    }

}