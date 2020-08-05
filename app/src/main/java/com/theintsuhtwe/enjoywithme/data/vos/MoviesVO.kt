package com.theintsuhtwe.enjoywithme.data.vos


import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.typeconverters.MovieTypeConverter
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.GenresIdTypeConverter

@Entity(tableName = "movies")
@TypeConverters(GenresIdTypeConverter::class)
class MoviesVO {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int ?= null
    @ColumnInfo(name = "original_title")
    var originalTitle: String ?= null
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    var backdropPath: String ?= null
    @ColumnInfo(name = "title")
    var title: String ?= null
    @ColumnInfo(name = "moview_title")
    var movieTitle: String ?= null
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String ?= null
    @ColumnInfo(name = "popularity")
    var popularity: Double ?= null
    @ColumnInfo(name = "vote_count")
    var vote_count: Int ?= null
    @ColumnInfo(name = "video")
    var videoStatus: Boolean ?= null
    @ColumnInfo(name = "adult")
    var adultStatus: Boolean ?= null
    @ColumnInfo(name = "media_type")
    var mediaType: String ?= null
    @ColumnInfo(name = "vote_average")
    var voteAvagere: Double ?= null
    @ColumnInfo(name = "overview")
    var overView: String ?= null
    @ColumnInfo(name = "release_date")
    var releaseDate: String ?= null
    @ColumnInfo(name = "first_air_date")
    var firstAirDate: String ?= null
    @ColumnInfo(name = "original_language")
    var original_language: String ?= null
//    @ColumnInfo(name = "genre_ids")
//    var genre_ids: ArrayList<Int> = arrayListOf()
    @ColumnInfo(name = "name")
    var name: String ?= null
    @ColumnInfo(name = "original_name")
    var originalName: String?= null

}


