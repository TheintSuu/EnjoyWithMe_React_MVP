package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.smarteist.autoimageslider.SliderViewAdapter
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.VideoDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.MainSliderViewHolder

class MovieSliderAdapter(delegate: MovieItemDelegate): SliderViewAdapter<MainSliderViewHolder>() {

    val mDelegate = delegate
   // val mVideoDelegate = videoDelegate

    private var mData = listOf<MoviesVO>()
    override fun onCreateViewHolder(parent: ViewGroup?): MainSliderViewHolder {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_upcoming_view, parent, false)
        return MainSliderViewHolder(view, mDelegate)
    }

    override fun getCount(): Int {
        return mData.count()
    }

    fun setData(data: List<MoviesVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: MainSliderViewHolder?, position: Int) {
        viewHolder?.bindData(mData[position])
    }
}
