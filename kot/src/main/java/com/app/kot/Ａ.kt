package com.app.kot

/**
 * Created by liulb1 on 2019/7/12.
 */
class A: Person {

    constructor(name:String):super(name){

    }

    lateinit var mListener :(String) -> Unit

    private lateinit var mSimpleCallBack :SimpleCallback

    override fun getName() {

    }

    fun setClickListener(listener :(a :Int,b:String) ->Unit){
        //mListener = listener
        listener.invoke(1111111,"2222222")
    }

    fun setSimpleCallBack(listener: Builder.() -> Unit){
        var builder = Builder()
        builder.listener()
        mSimpleCallBack = builder
        mSimpleCallBack.onSuccess("111")
        mSimpleCallBack.onFailed(10,"222")
    }

    fun setTest(){

    }

}