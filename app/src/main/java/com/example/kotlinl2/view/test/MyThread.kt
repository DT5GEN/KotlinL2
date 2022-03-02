package com.example.kotlinl2.view.test

import android.os.Looper

class MyThread : Thread() {
    override fun run() {
        Looper.prepare()
        Looper.loop()
    }
}
