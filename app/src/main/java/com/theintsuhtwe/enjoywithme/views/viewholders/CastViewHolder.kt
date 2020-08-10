package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.CastVO
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class CastViewHolder(itemView: View, delegate: ActorAndCrewItemDelegate) : BaseViewHolder<CastVO>(itemView) {

    val mDelegate = delegate

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapActorItem(it.cast_id!!)
            }
        }
    }

    override fun bindData(data: CastVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL +data.profile_path)
            .into(itemView.ivActorImage)

        itemView.tvActorName.text = data.name.toString()

    }
}