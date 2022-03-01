package com.example.kotlinl2.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.example.kotlinl2.R
import com.example.kotlinl2.databinding.MainActivityBinding
import com.example.kotlinl2.databinding.MainActivityWebviewBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.logging.LogManager
import java.util.stream.Collector
import java.util.stream.Collectors


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
  //  private lateinit var binding: MainActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = MainActivityBinding.inflate(layoutInflater)
      //  binding = MainActivityWebviewBinding.inflate(layoutInflater)
        val view = binding.getRoot()
        setContentView(view)
//        var clickListener: View.OnClickListener = object : View.OnClickListener {
//            @RequiresApi(Build.VERSION_CODES.N)
//
//            override fun onClick(p0: View?) {
//                try {
//
//
//                    val uri = URL(binding.url.text.toString())
//                    val handler = Handler()
//
//                    Thread {
//
//                        var urlConnection: HttpURLConnection? = null
//                        try {
//
//
//                            urlConnection = uri.openConnection() as HttpURLConnection
//                            urlConnection.requestMethod = "GET"
//                            urlConnection.readTimeout = 10000
//
//                            val reader =
//                                BufferedReader(InputStreamReader(urlConnection.inputStream))
//
//                            val result = getLines(reader)
//
//                            handler.post {
//
//                                binding.webview.loadDataWithBaseURL(null,
//                                    result,
//                                    "text/html; charset=utf-8",
//                                    "utf-8", null
//                                )
//
//                            }
//                        } catch (e: Exception) {
//                            Log.e("e", "Fail connection", e)
//                            e.printStackTrace()
//                        } finally {
//                            urlConnection?.disconnect()
//                        }
//
//                    }.start()
//                } catch (e: MalformedURLException) {
//                    Log.e("i", "Fail URI", e)
//                    e.printStackTrace()
//                }
//
//
//            }
//            @RequiresApi(Build.VERSION_CODES.N)
//            private fun getLines(reader: BufferedReader): String {
//                return reader.lines().collect(Collectors.joining("\n"))
//            }
//
//        }
//        binding.ok.setOnClickListener(clickListener)

        savedInstanceState?.let {
            // TODO
        } ?: run {

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }


//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }


    }
}