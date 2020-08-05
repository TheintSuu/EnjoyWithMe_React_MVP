package com.example.travelapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.view.viewholder.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData: MutableList<W> = mutableListOf()
    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun appendNewData(data : List<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}