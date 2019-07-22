package com.app.poishuhui
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.app.poishuhui.ui.adapter.ContentPagerAdapter
import com.app.poishuhui.ui.fragment.BookFragment
import com.app.poishuhui.ui.fragment.HomeFragment
import com.app.poishuhui.ui.fragment.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var GITHUB_URL = "https://github.com/wuapnjie/PoiShuhui-Kotlin"
    }

    var nameResList: ArrayList<Int> = arrayListOf(R.string.tab_one, R.string.tab_two, R.string.tab_three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            jump2MyGithub()
        }

        var fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment())
        fragments.add(BookFragment())
        fragments.add(NewsFragment())

        var nameList = nameResList.map(this::getString)

        viewPager.adapter = ContentPagerAdapter(fragments,nameList,supportFragmentManager)
        viewPager.offscreenPageLimit = 2

        tabLayout.setupWithViewPager(viewPager)

    }

    private fun jump2MyGithub(){
        val uri = Uri.parse(GITHUB_URL)
        val  intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }

}
