package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.GenresIdTypeConverter


@Entity(tableName = "popularMovie")
@TypeConverters(GenresIdTypeConverter::class)
class PopularMoviesVO{
    @ColumnInfo(name ="popularity") var popularity: Float = 0.0f
    @ColumnInfo(name ="poster_path") var poster_path: String? = null
    @ColumnInfo(name ="overview") var overview: String? = null
    @ColumnInfo(name ="release_date") var release_date: String = ""
//    @ColumnInfo(name ="genre_ids")var genre_ids: ArrayList<Int> = arrayListOf()
    @PrimaryKey
    @ColumnInfo(name ="id") var id: Int = 0
    @ColumnInfo(name ="original_language") var original_language: String = ""
    @ColumnInfo(name ="original_title") var original_title: String = ""
    @ColumnInfo(name ="title")var title: String? = null
    @ColumnInfo(name ="backdrop_path") var backdrop_path: String? = null
    @ColumnInfo(name ="video") var video: Boolean = false
    @ColumnInfo(name ="vote_average") var vote_average: Float = 0.0f
    @ColumnInfo(name ="vote_count") var vote_count: Int = 0

}