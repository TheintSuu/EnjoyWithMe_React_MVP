package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.theintsuhtwe.enjoywithme.data.dummy.getTopRatedMovies
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO

object MockTopRatedMovieImpl:  TopRateMovieModel {
    var movie : MutableList<TopRatedVO> = arrayListOf()
    override fun getTopMovieFromApiSaveToDB(
        title: String,
        onSuccess: (List<TopRatedVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        val liveData = MutableLiveData<List<TopRatedVO>>()
        liveData.postValue(getTopRatedMovies())
    }

    override fun getAllTopMovieList(onError: (String) -> Unit): LiveData<List<TopRatedVO>> {
        val liveData = MutableLiveData<List<TopRatedVO>>()
        liveData.postValue(getTopRatedMovies())
        return liveData
    }

}