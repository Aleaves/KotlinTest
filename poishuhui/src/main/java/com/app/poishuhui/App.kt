package com.app.poishuhui

import android.app.Application
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient

/**
 * Created by liulb1 on 2019/7/15.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化 picasso下载
        var client = OkHttpClient()
        var picasso = Picasso.Builder(this).downloader(OkHttp3Downloader(client)).build()
        Picasso.setSingletonInstance(picasso)
    }

}