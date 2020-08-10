package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.BuildConfig
import com.theintsuhtwe.enjoywithme.data.model.BaseModel
import com.theintsuhtwe.enjoywithme.data.model.TopRateMovieModel
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object TopRatedMovieImpl : BaseModel(), TopRateMovieModel {

    @SuppressLint("CheckResult")
    override fun getTopMovieFromApiSaveToDB(
        title: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        var tabTitle : String ?= null
        if (title == null){
            tabTitle = "Adventure"
        }else{
            tabTitle = title
        }
        TopRatedMovieImpl.mMoviesApi
            .getAllTopRatedMovies(BuildConfig.API_KEY.toString(), tabTitle)
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.TopRatedVODao().deleteAll()
                TopRatedMovieImpl.mTheDB.TopRatedVODao().insertTopRateMovieList(it)

            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


    }

    override fun getAllTopMovieList( onError: (String) -> Unit): LiveData<List<TopRatedVO>> {
        return mTheDB.TopRatedVODao().getAllTopRateMovie()
    }
}