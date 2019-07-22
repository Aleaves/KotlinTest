package com.app.poishuhui.network

/**
 * Created by liulb1 on 2019/7/16.
 */
interface Source<out T> {

    fun obtain(url : String): T

}