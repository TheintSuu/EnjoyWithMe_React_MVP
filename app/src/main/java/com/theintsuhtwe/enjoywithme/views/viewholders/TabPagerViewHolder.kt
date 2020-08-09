package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.delegate.TabPagerDelegate

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