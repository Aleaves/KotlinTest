package com.app.poishuhui.ui.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.poishuhui.R
import com.app.poishuhui.loadUrl
import com.app.poishuhui.ui.adapter.kits.AnotherViewHolder
import com.app.poishuhui.ui.adapter.kits.ItemBinder
import com.app.poishuhui.ui.model.Cover
import kotlinx.android.synthetic.main.item_cover.view.*

/**
 * Created by liulb1 on 2019/7/16.
 */
class CoverBinder : ItemBinder.AnotherBinder<Cover>() {

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): AnotherViewHolder {
        val view = inflater.inflate(R.layout.item_cover, parent, false)
        return AnotherViewHolder(view)
    }

    override fun renderView(holder: AnotherViewHolder, itemView: View, item: Cover) {
        itemView.tvCover.text = item.title
        itemView.ivCover.loadUrl(item.coverUrl)
    }

}
