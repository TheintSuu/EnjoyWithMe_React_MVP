package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.data.vos.VideoVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface MoviesModel {

    fun getAllMovies(onError: (String) -> Unit) : LiveData<List<MoviesVO>>

    fun getAllMoviesFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMoviesById(MoviesId: Int) : LiveData<MoviesVO>

    fun getVideoByMovieById(movieId: Int,onSuccess:(List<VideoVO>)->Unit,onError: (String) -> Unit)

}