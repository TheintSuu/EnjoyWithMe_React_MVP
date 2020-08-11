package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.theintsuhtwe.enjoywithme.data.dummy.getTabTitle
import com.theintsuhtwe.enjoywithme.data.dummy.getTopRatedMovies
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO

object  MockGenersModelImpl : GenersModel{
    override fun getPopularGenersFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllGenersList(onError: (String) -> Unit): LiveData<List<GenersVO>> {
        val liveData = MutableLiveData<List<GenersVO>>()
        liveData.postValue(getTabTitle())
        return liveData
    }

    override fun getGenersById(title: String, onError: (String) -> Unit): LiveData<GenersVO> {
        val liveData = MutableLiveData<GenersVO>()
        liveData.postValue(getTabTitle().get(0))
        return liveData
    }

}