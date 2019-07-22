package com.app.poishuhui.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup

/**
 * Created by liulb1 on 2019/7/15.
 */
class ContentPagerAdapter(private val fragments:List<Fragment>, private val nameList: List<String>, fm:FragmentManager):FragmentPagerAdapter(fm) {


    override fun getItem(p0: Int): Fragment? = fragments[p0]

    override fun getCount(): Int = fragments.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? = nameList[position]

}