package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO


interface TopRateMovieModel  {
    fun getTopMovieFromApiSaveToDB(title : String ,
                                   onSuccess:(List<TopRatedVO>)->Unit,onError:(String) ->Unit)

    fun getAllTopMovieList( onError: (String) -> Unit) : LiveData<List<TopRatedVO>>



}