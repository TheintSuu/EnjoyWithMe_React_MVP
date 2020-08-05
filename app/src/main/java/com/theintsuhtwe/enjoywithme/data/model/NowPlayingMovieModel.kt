package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO


interface NowPlayingMovieModel {

    fun getAllNowPlayingMovieFromApiSaveToDatabase(onSuccess: ()->Unit,
    onFailure:(String)->Unit)

    fun getAllNowPlayingMovieList(onError:(String) ->Unit): LiveData<List<NowPlayingVO>>
}