package com.theintsuhtwe.enjoywithme.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO

class GetAllTopRatedMoviesResponse (
    @SerializedName("page") val code : Int  = 0,
    @SerializedName("total_results") val totalResult : Int  = 0,
    @SerializedName("total_pages") val totalPage : Int = 0,
    @SerializedName("results") val data : ArrayList<TopRatedVO> = arrayListOf()
){
    fun isResponseOk() =  (data != null) //&& // (code == 200)
}