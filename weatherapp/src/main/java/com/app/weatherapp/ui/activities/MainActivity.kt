package com.app.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.app.weatherapp.R
import org.jetbrains.anko.find

class MainActivity : CoroutineScopeActivity(),ToolbarManager{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

    }

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

}
