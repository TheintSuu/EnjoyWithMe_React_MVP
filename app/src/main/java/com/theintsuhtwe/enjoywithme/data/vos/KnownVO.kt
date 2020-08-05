package com.theintsuhtwe.enjoywithme.data.vos

import com.google.gson.annotations.SerializedName

data class KnownVO (

    @SerializedName("original_title") var originalTitle: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("movie_title") var movieTitle: String = "",
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("vote_count") var vote_count: Int = 0,
    @SerializedName("video") var videoStatus: Boolean = false,
    @SerializedName("adult") var adultStatus: Boolean = false,
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("media_type") var mediaType: String = "",
    @SerializedName("vote_average") var voteAvagere: Double = 0.0,
    @SerializedName("overview") var overView: String = "",
    @SerializedName("release_date") var releaseDate: String = ""
)