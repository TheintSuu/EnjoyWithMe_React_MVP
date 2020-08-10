package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.CrewVO
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_creator.view.*

class CreatorViewHolder(itemView: View, delegate: ActorAndCrewItemDelegate) : BaseViewHolder<CrewVO>(itemView) {

    init {

        itemView.setOnClickListener {
            mData?.let {
                //delegate.onTapActorItem(it.credit_id!!)
            }
        }
    }

    override fun bindData(data: CrewVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.profile_path)
            .into(itemView.ivCreatorImage)

        itemView.tvCreatorName.text = data.name.toString()

    }
}