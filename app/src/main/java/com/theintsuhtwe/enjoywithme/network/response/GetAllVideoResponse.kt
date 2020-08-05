package com.theintsuhtwe.enjoywithme.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.VideoVO

class GetAllVideoResponse (

    @SerializedName("results") val data: ArrayList<VideoVO> = arrayListOf()
){
    fun isResponseOk() =  (data != null)// &&  (code == 200)
}