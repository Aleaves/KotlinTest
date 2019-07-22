package com.app.kot

/**
 * Created by liulb1 on 2019/7/15.
 */
class Builder :SimpleCallback{

    private lateinit var onSuccessVal : (response:String) -> Unit

    fun onSuccessFun (listener :(response:String)->Unit){
        this.onSuccessVal = listener
    }

    override fun onSuccess(response: String) {
        onSuccessVal.invoke(response)
    }

    private lateinit var onFailedVal :(errorCode :Int,msg:String) ->Unit

    fun onFailedFun(listener:(errorCode :Int,msg :String) ->Unit){
        this.onFailedVal = listener
    }

    override fun onFailed(errorCode: Int, msg: String) {
        onFailedVal.invoke(errorCode,msg)
    }


}