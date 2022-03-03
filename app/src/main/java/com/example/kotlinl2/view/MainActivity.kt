package com.example.kotlinl2.view

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinl2.R
import com.example.kotlinl2.databinding.MainActivityBinding
import com.example.kotlinl2.view.test.MainBroadcastReceiver


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    private val receiver = MainBroadcastReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = MainActivityBinding.inflate(layoutInflater)

        val view = binding.getRoot()
        setContentView(view)


        savedInstanceState?.let {
            // TODO
        } ?: run {

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}