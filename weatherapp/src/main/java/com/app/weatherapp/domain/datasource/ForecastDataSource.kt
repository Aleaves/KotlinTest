package com.app.weatherapp.domain.datasource

import com.app.weatherapp.domain.model.Forecast
import com.app.weatherapp.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode (zipCode : Long,date : Long): ForecastList?

    fun requestDayForecast (id : Long) : Forecast?

}