package com.app.poishuhui.network

import android.util.Log
import com.app.poishuhui.getHtml
import com.app.poishuhui.ui.model.Cover
import org.jsoup.Jsoup

/**
 * Created by liulb1 on 2019/7/16.
 */
class CoverSource :Source<ArrayList<Cover>> {

    override fun obtain(url: String): ArrayList<Cover> {

        val list = ArrayList<Cover>()
        val html = getHtml(url)
        Log.i("========",html)

        val doc = Jsoup.parse(html)
        val elements = doc.select("ul.mangeListBox").select("li")

        for (element in elements) {
            val coverUrl = element.select("img").attr("src")
            val title = element.select("h1").text() + "\n" + element.select("h2").text()
            val link = "http://ishuhui.net" + element.select("div.magesPhoto").select("a").attr("href")
            val cover = Cover(coverUrl, title, link)
            list.add(cover)
        }

        return list
    }

}