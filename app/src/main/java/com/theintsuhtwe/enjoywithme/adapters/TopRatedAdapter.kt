package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.BaseAdapter
import com.example.shared.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.TopRatedViewHolder

class TopRatedAdapter(delegate: MovieItemDelegate) : BaseAdapter<BaseViewHolder<TopRatedVO>, TopRatedVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_films_and_series,parent,false)
        return TopRatedViewHolder(view, mDelegate)
    }

}