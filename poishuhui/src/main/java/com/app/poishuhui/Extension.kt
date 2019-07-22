package com.app.poishuhui

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by liulb1 on 2019/7/16.
 */
fun ImageView.loadUrl(url:String){
    Picasso.with(this.context)
            .load(url)
            .into(this)
}

fun getHtml(url : String) : String{

    val client = OkClient.instance
    val request = Request.Builder().url(url).build()

    val response = client.newCall(request).execute()

    return response.body()?.string()?:""

}