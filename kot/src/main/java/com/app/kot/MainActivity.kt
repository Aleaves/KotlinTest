package com.app.kot

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {


    var test by Delegates.observable(0){property, oldValue, newValue ->

        println("====="+newValue)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        var a = A("12")
        a.name

//        a.setClickListener(object : B {
//            override fun getName(name: String) {
//                println("======="+name)
//            }
//        })

//        a.setClickListener(object : OnNameListener{
//            override fun onNameDone(name: String) {
//
//            }
//        })
//        a.setClickListener{ i: Int, s: String ->
//            Log.i("========",i.toString())
//            Log.i("========",s)
//        }

        a.setSimpleCallBack {
            onSuccessFun {
                response ->
                Log.i("========",response)
            }
            
            onFailedFun { errorCode, msg ->
                Log.i("========",errorCode.toString()+"=="+msg)
            }

        }
        a.setClickListener { a, b ->

        }

//        A("123").apply {
//            setClickListener(object :B{
//                override fun getName(name: String) {
//
//                }
//            })
//            setTest()
//        }

        test = 1
        test = 2
        test = 3
        test = 4
        test = 5

    }

    enum class Test{
        RED,CL
    }
}