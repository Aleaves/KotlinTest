package com.app.weatherapp.data.server

import com.app.weatherapp.data.db.ForecastDb
import com.app.weatherapp.domain.datasource.ForecastDataSource
import com.app.weatherapp.domain.model.Forecast
import com.app.weatherapp.domain.model.ForecastList

class ForecastServer(private val dataMapper : ServerDataMapper = ServerDataMapper(),private val forecastDb : ForecastDb = ForecastDb()) : ForecastDataSource{

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()

}