package com.app.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import com.app.weatherapp.R
import com.app.weatherapp.domain.commands.RequestForecastCommand
import com.app.weatherapp.extensions.DelegatesExt
import com.app.weatherapp.extensions.Preference
import kotlin.properties.Delegates


class MainActivity : CoroutineScopeActivity(),ToolbarManager{

    private var zipCode by DelegatesExt.preference(this,SettingsActivity.ZIP_CODE,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
        var list = arrayListOf<String>("11","22","33")
        list.map {
            Log.i("=========",it)
        }

        list.forEach {

        }

    }

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast(){
        //val result = RequestForecastCommand
    }

}
