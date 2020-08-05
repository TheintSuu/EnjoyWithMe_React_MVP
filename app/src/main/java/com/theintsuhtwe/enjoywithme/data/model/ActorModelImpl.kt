package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object ActorModelImpl : BaseModel(),ActorModel {

    @SuppressLint("CheckResult")
    override fun getPopularActorFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        ActorModelImpl.mMoviesApi
            .getAllActors(API_KEY_CODE)
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
               ActorModelImpl.mTheDB.ActorsDao().insertAllActor(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllActorPoster(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.ActorsDao().getPosterPath()
    }

    override fun getAllActorList(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.ActorsDao().getAllActor()
    }


}