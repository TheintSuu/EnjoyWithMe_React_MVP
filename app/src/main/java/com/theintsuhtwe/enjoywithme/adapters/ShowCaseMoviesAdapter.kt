package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.ShowCaseViewHolder


class ShowCaseMoviesAdapter(delegate: MovieItemDelegate) : BaseAdapter<BaseViewHolder<NowPlayingVO>, NowPlayingVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<NowPlayingVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_showcase, parent, false)
        return ShowCaseViewHolder(view, mDelegate)
    }




}