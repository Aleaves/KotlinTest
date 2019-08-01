package com.mg.axechen.wanandroid.base

import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var immersionBar: ImmersionBar

    private var mCurrentTheme: Int = 0



}