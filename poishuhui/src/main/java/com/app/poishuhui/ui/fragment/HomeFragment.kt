package com.app.poishuhui.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.poishuhui.R
import com.app.poishuhui.network.CoverSource
import com.app.poishuhui.ui.adapter.AnotherAdapter
import com.app.poishuhui.ui.binder.CoverBinder
import com.app.poishuhui.ui.model.Cover
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by liulb1 on 2019/7/15.
 */
class HomeFragment : Fragment() {

    companion object {
        val AIM_URL = "http://ishuhui.net/?PageIndex=1"
    }

    var mData = ArrayList<Cover>()

    lateinit var coverList : RecyclerView

    lateinit var homeRefresh :SwipeRefreshLayout

    lateinit var adapter : AnotherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view:View){
        homeRefresh = view.homeRefresh
        coverList = view.homeList

        coverList.layoutManager = GridLayoutManager(context,2)
        adapter = AnotherAdapter().with(Cover::class.java,CoverBinder())
        coverList.adapter = adapter

        homeRefresh.setOnRefreshListener {
            load()
        }

        homeRefresh.post {
            homeRefresh.isRefreshing = true
        }

    }

    private fun load(){
        doAsync{
            val data = CoverSource().obtain(AIM_URL)
            uiThread {
                mData = data
                adapter.update(data)
                homeRefresh.isRefreshing = false
            }
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.i("============","setUserVisibleHint")
        if (isVisibleToUser && mData.size == 0) {
            load()
        }

    }


}