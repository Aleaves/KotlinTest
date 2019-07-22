package com.app.poishuhui.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.poishuhui.ui.adapter.kits.ItemBinder

/**
 * Created by liulb1 on 2019/7/15.
 */
class AnotherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater : LayoutInflater? = null

    val items = arrayListOf<Any>()
    val types = arrayListOf<Class<*>>()
    val binders = arrayListOf<ItemBinder<*,*>>()

    fun with(clazz: Class<*>,binder: ItemBinder<*,*>):AnotherAdapter{
        if(types.contains(clazz)){
            val index = types.indexOf(clazz)
            types.removeAt(index)
            binders.removeAt(index)
        }
        types += clazz
        binders += binder
        return this
    }

    fun update(newData:List<Any>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    fun insert(item:Any,position:Int){
        if(types.contains(item.javaClass)){
            items.add(position,item)
            notifyItemChanged(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        val type = types.indexOf(item.javaClass)
        return type
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = getItemViewType(position)
        val binder = binders[type]
        val item = items[position]
        binder.adapter = this
        (binder as ItemBinder<Any,RecyclerView.ViewHolder>).bindViewHolder(holder,item)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binder = binders[viewType]
        inflater?.let { inflater = LayoutInflater.from(parent.context) }
        var holder = (binder as ItemBinder<Any,RecyclerView.ViewHolder>).createViewHolder(inflater?: LayoutInflater.from(parent.context),parent)
        return  holder
    }

}