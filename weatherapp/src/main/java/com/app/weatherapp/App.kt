package com.app.weatherapp

import android.app.Application

/**
 * Created by liulb1 on 2019/7/16.
 */
class App : Application() {

    companion object {
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}