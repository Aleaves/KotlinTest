package com.app.weatherapp.domain.datasource

class ForecastProvider(private val sources :Int) {

    companion object{
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy {

        }
    }

}