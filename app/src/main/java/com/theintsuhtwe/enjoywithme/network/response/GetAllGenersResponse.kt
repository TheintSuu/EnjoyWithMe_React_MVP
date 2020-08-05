package com.theintsuhtwe.enjoywithme.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

class GetAllGenersResponse(
//    @SerializedName("page") val code : Int  = 0,
//    @SerializedName("total_results") val totalResult : Int  = 0,
//    @SerializedName("total_pages") val totalPage : Int = 0,
    @SerializedName("genres") val data: ArrayList<GenersVO> = arrayListOf()
){
    fun isResponseOk() =  (data != null)// &&  (code == 200)
}