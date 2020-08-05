package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO

interface GenersModel {
    fun getPopularGenersFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)


    fun getAllGenersList(onError:(String) ->Unit): LiveData<List<GenersVO>>
}