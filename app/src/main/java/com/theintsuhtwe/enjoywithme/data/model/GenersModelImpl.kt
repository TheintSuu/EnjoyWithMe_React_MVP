package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.theintsuhtwe.enjoywithme.BuildConfig
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GenersModelImpl : BaseModel(),GenersModel {

    @SuppressLint("CheckResult")
    override fun getPopularGenersFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        GenersModelImpl.mMoviesApi
            .getAllGeners(BuildConfig.API_KEY.toString())
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
        return Transformations.distinctUntilChanged(mTheDB.GenersDao().getAllgeners())
    }

    override fun getGenersById(title : String, onError: (String) -> Unit): LiveData<GenersVO> {
        return mTheDB.GenersDao().getgenersById(title)
    }


}