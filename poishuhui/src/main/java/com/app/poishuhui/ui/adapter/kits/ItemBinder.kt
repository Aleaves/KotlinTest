package com.app.poishuhui.ui.adapter.kits

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import com.app.poishuhui.ui.adapter.AnotherAdapter

/**
 * Created by liulb1 on 2019/7/15.
 */
abstract class ItemBinder<T : Any, VH : RecyclerView.ViewHolder> {

    var itemClickListener : ((item:T,position:Int) -> Unit)? = null

    lateinit var adapter : AnotherAdapter

    abstract fun createViewHolder(inflater: LayoutInflater,parent: ViewGroup):VH

    abstract fun bindViewHolder(holder: VH,item: T)

    fun clickWith(listener : (item :T,position :Int) -> Unit) = apply {
        itemClickListener = listener
    }

    abstract fun renderView(holder:AnotherViewHolder,itemView:View,item:T)

    abstract class AnotherBinder<T:Any> : ItemBinder<T,AnotherViewHolder>(){
        override fun bindViewHolder(holder: AnotherViewHolder, item: T) {
            renderView(holder,holder.itemView,item)
        }
    }

}