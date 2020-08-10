package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorViewHolder(itemView: View, delegate: ActorAndCrewItemDelegate) : BaseViewHolder<ActorVO>(itemView) {

    val mDelegate = delegate

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapActorItem(it.id)
            }
        }
    }

    override fun bindData(data: ActorVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.profilePath)
            .into(itemView.ivActorImage)

        itemView.tvActorName.text = data.name.toString()

    }
}