package com.app.weatherapp.domain.commands

import com.app.weatherapp.domain.datasource.ForecastProvider

class RequestForecastCommand(private val zipCode : Long,private val forecastProvider : ForecastProvider = ForecastProvider()) {

}