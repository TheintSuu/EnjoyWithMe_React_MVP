package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowCaseViewHolder(itemView: View, delegate: MovieItemDelegate) : BaseViewHolder<NowPlayingVO>(itemView) {
    val mDelegate = delegate

    init{
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapMovieItem(it.id)
            }
        }
    }

    override fun bindData(data:NowPlayingVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.poster_path)
            .into(itemView.ivShowCaseImage)

        itemView.tvMovieTitle.text = data.title.toString()
        itemView.tvDate.text = data.release_date.toString()
    }
}