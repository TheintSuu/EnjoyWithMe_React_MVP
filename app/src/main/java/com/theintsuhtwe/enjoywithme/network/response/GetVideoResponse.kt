package com.theintsuhtwe.enjoywithme.network.response



import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.VideoVO

data class GetVideoResponse(
    @SerializedName("id") var id :Int,
    @SerializedName("results") var result : ArrayList<VideoVO> = arrayListOf()
)
