package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.BuildConfig
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.CastAndCrewVO
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieDetailModelImpl : BaseModel(), MovieDetailModel {

    override fun getMovieDetail(id: Int, onError: (String) -> Unit): LiveData<MovieDetailVO> {
        return mTheDB.MovieDetailDao().getMovieById(id)
    }


    @SuppressLint("CheckResult")
    override fun getMovieDetailsAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
       MovieDetailModelImpl.mMoviesApi.getMovieDetailsById(movieId, BuildConfig.API_KEY.toString())
            .map { it.let { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.MovieDetailDao().insertMovieDetail(it)
            }, {
                onError(it.localizedMessage ?: "Error")
            })
    }

    override fun getAllActors(onError: (String) -> Unit): LiveData<List<ActorVO>> {
      return mTheDB.ActorsDao().getAllActor()
    }



    @SuppressLint("CheckResult")
    override fun getAllCastAndCrewFromApiSaveDataBase(
        id: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        MovieDetailModelImpl.mMoviesApi.
        getCastAndCrew(id, BuildConfig.API_KEY.toString())
            .map {
                it.let { it }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               MovieDetailModelImpl.mTheDB.CrewAndCrewDao().insertCast(it)
            }, {
                onError(it.localizedMessage ?: it.localizedMessage)
            })


    }

    override fun getAllCastAndCrew(id: Int, onError: (String) -> Unit): LiveData<CastAndCrewVO> {
       val m= mTheDB.CrewAndCrewDao().getCastById(id)
        return m
    }
}