package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.CastAndCrewVO
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

interface MovieDetailModel {
    fun getMovieDetail(id : Int, onError: (String) -> Unit) : LiveData<MovieDetailVO>

    fun getMovieDetailsAndSaveToDatabase(id:Int,onSuccess: ()->Unit,onError: (String)->Unit)


    fun getAllActors(onError: (String) -> Unit): LiveData<List<ActorVO>>

    fun getAllCastAndCrewFromApiSaveDataBase(id:Int,onSuccess:()->Unit,onError:(String)->Unit)

    fun getAllCastAndCrew(id: Int,onError: (String) -> Unit): LiveData<CastAndCrewVO>
}