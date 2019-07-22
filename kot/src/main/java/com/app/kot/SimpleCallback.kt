package com.app.kot

/**
 * Created by liulb1 on 2019/7/15.
 */
interface SimpleCallback {
    fun onSuccess(response: String)
    fun onFailed (errorCode :Int,msg :String)
}