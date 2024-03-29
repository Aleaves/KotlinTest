package com.app.weatherapp.data.server

import com.app.weatherapp.data.db.ForecastDb
import com.app.weatherapp.domain.datasource.ForecastDataSource
import com.app.weatherapp.domain.model.Forecast
import com.app.weatherapp.domain.model.ForecastList

class ForecastServer(private val dataMapper : ServerDataMapper = ServerDataMapper(),private val forecastDb : ForecastDb = ForecastDb()) : ForecastDataSource{

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode,result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode,date)
    }

    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()

}