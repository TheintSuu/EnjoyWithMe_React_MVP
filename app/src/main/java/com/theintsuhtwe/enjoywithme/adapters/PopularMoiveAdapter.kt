package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.PopularMovieViewHolder

class PopularMoiveAdapter(delegate: MovieItemDelegate) : BaseAdapter<BaseViewHolder<PopularMoviesVO>, PopularMoviesVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PopularMoviesVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular_films_and_series, parent, false)
        return PopularMovieViewHolder(view, mDelegate)
    }




}