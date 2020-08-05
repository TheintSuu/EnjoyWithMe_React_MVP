package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO


interface PopularMovieModel {
    fun getAllPopularMovieFromApiSaveToDatabase(onSuccess:()->Unit,onError:(String)->Unit)

    fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>>

    fun getPosterPath(onError: (String) -> Unit):LiveData<List<PopularMoviesVO>>
}