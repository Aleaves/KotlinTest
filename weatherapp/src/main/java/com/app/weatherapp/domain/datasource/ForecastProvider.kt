package com.app.weatherapp.domain.datasource

import com.app.weatherapp.data.db.ForecastDb
import com.app.weatherapp.data.server.ForecastServer

class ForecastProvider(private val sources : List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object{
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy {
            listOf(ForecastDb(),ForecastServer())
        }
    }

}