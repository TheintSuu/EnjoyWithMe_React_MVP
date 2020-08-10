package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object NowPlayingMovieImpl : BaseModel(), NowPlayingMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllNowPlayingMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        NowPlayingMovieImpl.mMoviesApi
            .getAllNowPlayingMovies(BuildConfig.API_KEY.toString())
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.NowPlayingMovieDao().insertNowPlayingMovieList(it)
            },{
                onFailure(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllNowPlayingMovieList(onError:(String) ->Unit): LiveData<List<NowPlayingVO>> {
     return  mTheDB.NowPlayingMovieDao().getAllNowPlaying()
    }
}