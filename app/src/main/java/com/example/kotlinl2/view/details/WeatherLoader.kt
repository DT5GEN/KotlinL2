package com.example.kotlinl2.view.details

import android.os.Build
import android.os.Handler
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.kotlinl2.BuildConfig
import com.example.kotlinl2.model.WeatherDTO
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection


@RequiresApi(Build.VERSION_CODES.N)
class WeatherLoader(
    private val listener: WeatherLoaderListener,
    private val lat: Double,
    private val lon: Double
) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun loadWeather() {


        try {
            val uri = URL("https://api.weather.yandex.ru/v2/informers?lat=${lat}&lon=${lon}")
            val handler = Handler()

            Thread {
                lateinit var urlConnection: HttpsURLConnection
                try {


                    urlConnection = uri.openConnection() as HttpsURLConnection
                        urlConnection.requestMethod = "GET"
                        urlConnection.readTimeout = 10000

                    urlConnection.addRequestProperty(
                            "X-Yandex-API-Key",
                            BuildConfig.WEATHER_API_KEY
                        )



                    val bufferedReader =
                        BufferedReader(InputStreamReader(urlConnection.inputStream))

                    val response = getLines(bufferedReader)

                    val weatherDTO: WeatherDTO =
                        Gson().fromJson(response, WeatherDTO::class.java)

                    handler.post {

                    }

                } catch (e: Exception) {
                    Log.e("e", "Fail connection", e)
                    e.printStackTrace()
                    listener.onFailed(e)
                } finally {
                    urlConnection.disconnect()
                }
            }.start()

        } catch (e: MalformedURLException) {
            Log.e("i", "Fail URI", e)
            e.printStackTrace()
            listener.onFailed(e)
        }

    }
}


    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }


    interface WeatherLoaderListener {
        fun onLoaded(weatherDTO: WeatherDTO)
        fun onFailed(throwable: Throwable)
    }
