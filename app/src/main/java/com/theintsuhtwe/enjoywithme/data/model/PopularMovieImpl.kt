package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.BuildConfig

import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PopularMovieImpl : BaseModel(), PopularMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllPopularMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        PopularMovieImpl.mMoviesApi
            .getAllPopularMovies(BuildConfig.API_KEY.toString())
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({

                it?.let {
                    PopularMovieImpl.mTheDB.PopularMoviesDao().insertPopularMovieList(it)
                    //mTheDB.MoviesDao().insertAllMovies(it)
                }

            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>> {
        return mTheDB.PopularMoviesDao().getAllPopularMovie()
    }

    override fun getPosterPath(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>> {
        return mTheDB.PopularMoviesDao().getPosterPath()
    }
}