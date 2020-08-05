package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.TabPagerDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_films_and_series.view.*

class  TagPagerViewHolder(itemView: View, delegate: TabPagerDelegate) : BaseViewHolder<GenersVO>(itemView) {

    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapItem(it.name!!)
            }
        }
    }

    override fun bindData(data: GenersVO) {
        mData = data

    }
}