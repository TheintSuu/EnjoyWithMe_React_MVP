package com.theintsuhtwe.enjoywithme.network.response


import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

data class GetMovieWithGenerResponse(
    @SerializedName("page")val page: Int,
    @SerializedName("total_results")var total_result : Int,
    @SerializedName("total_pages")var total_page: Int,
    @SerializedName("results")var result: ArrayList<MoviesVO> = arrayListOf()
)