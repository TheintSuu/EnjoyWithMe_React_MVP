package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GenersModelImpl : BaseModel(),GenersModel {

    @SuppressLint("CheckResult")
    override fun getPopularGenersFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        GenersModelImpl.mMoviesApi
            .getAllGeners(API_KEY_CODE)
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                GenersModelImpl.mTheDB.GenersDao().insertAllgeners(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }


    override fun getAllGenersList(onError: (String) -> Unit): LiveData<List<GenersVO>> {
        return mTheDB.GenersDao().getAllgeners()
    }


}