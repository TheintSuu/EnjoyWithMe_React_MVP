package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.BaseAdapter
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.CrewVO
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.CreatorViewHolder

class CreatorItemAdapter(delegate: ActorAndCrewItemDelegate) : BaseAdapter<BaseViewHolder<CrewVO>, CrewVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CrewVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_creator, parent, false)
        return CreatorViewHolder(view, mDelegate)
    }




}