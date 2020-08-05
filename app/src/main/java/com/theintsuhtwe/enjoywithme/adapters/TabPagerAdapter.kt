package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.delegate.TabPagerDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.MainSliderViewHolder
import com.theintsuhtwe.enjoywithme.views.viewholders.TagPagerViewHolder

class TabPagerAdapter(delegate: TabPagerDelegate ) : BaseAdapter<BaseViewHolder<GenersVO>, GenersVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GenersVO> {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_upcoming_view, parent, false)
        return TagPagerViewHolder(view, mDelegate)
    }


}