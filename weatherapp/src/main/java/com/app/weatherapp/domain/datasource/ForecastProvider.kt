package com.app.weatherapp.domain.datasource

import com.antonioleiva.weatherapp.extensions.firstResult
import com.app.weatherapp.data.db.ForecastDb
import com.app.weatherapp.data.server.ForecastServer
import com.app.weatherapp.domain.model.Forecast
import com.app.weatherapp.domain.model.ForecastList

class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy {
            listOf(ForecastDb(), ForecastServer())
        }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList =
            requestToSources {
                val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
                if (res != null && res.size >= days) res else null
            }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    fun requestForecast(id: Long):Forecast = requestToSources {
        it.requestDayForecast(id)
    }

    private fun <T:Any> requestToSources(f:(ForecastDataSource) -> T?):T =
            sources.firstResult {
                f(it)
            }

}