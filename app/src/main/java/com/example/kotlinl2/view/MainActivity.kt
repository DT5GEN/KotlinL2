package com.example.kotlinl2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinl2.R
import com.example.kotlinl2.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding


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




    }
}