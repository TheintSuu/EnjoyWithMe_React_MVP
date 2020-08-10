package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.BaseAdapter
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.CastVO
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.CastViewHolder

class CastAdapter(delegate: ActorAndCrewItemDelegate) : BaseAdapter<BaseViewHolder<CastVO>, CastVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CastVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actor, parent, false)
        return CastViewHolder(view, mDelegate)
    }
}