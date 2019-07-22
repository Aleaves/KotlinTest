package com.app.weatherapp.ui.activities

import android.content.Intent
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.app.weatherapp.App
import com.app.weatherapp.R
import com.app.weatherapp.extensions.ctx
import com.app.weatherapp.extensions.slideEnter
import com.app.weatherapp.extensions.slideExit
import org.jetbrains.anko.toast

interface ToolbarManager {

    val toolbar : Toolbar

    var toolbarTile : String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_settings ->  toolbar.ctx.startActivity(Intent(toolbar.ctx,SettingsActivity::class.java))
                else -> App.instance.toast("Unknown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply {
        progress = 1f
    }

    fun attachToScroll(recyclerView: RecyclerView){
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0 ){
                    toolbar.slideExit()
                }else{
                    toolbar.slideEnter()
                }
            }
        })
    }

}