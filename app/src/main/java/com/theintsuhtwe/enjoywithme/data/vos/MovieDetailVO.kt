package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.GenerTypeConveter
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.ProductionCountryConverter

@Entity(tableName = "movieDetail")
@TypeConverters(GenerTypeConveter::class,
        ProductionCountryConverter::class)
class MovieDetailVO {

        @ColumnInfo( name ="adult") var adult: Boolean ?= null
        @ColumnInfo( name ="backdrop_path") var backdrop_path: String? = null
        @ColumnInfo( name ="budget") var budget: Int ?= null
        @ColumnInfo( name ="homepage") var homepage: String? = null
        @PrimaryKey
        @ColumnInfo( name ="id") var id: Int ?= null
        @ColumnInfo( name ="imdb_id") var imdb_id: String? = null
        @ColumnInfo( name ="original_language") var original_language: String ?= null
        @ColumnInfo( name ="original_title") var original_title: String ?= null
        @ColumnInfo( name ="overview") var overview: String? = null
        @ColumnInfo( name ="popularity") var popularity: Float ?= null
        @ColumnInfo( name ="poster_path")
        @SerializedName("poster_path")
        var poster_path: String? = null
        @ColumnInfo( name ="genres") var genres: ArrayList<GenersVO> = arrayListOf()
        @ColumnInfo( name ="production_countries") var production_countries: ArrayList<ProductionCountryVO> = arrayListOf()
        @ColumnInfo( name ="release_date") var release_date: String ?= null
        @ColumnInfo( name ="revenue") var revenue: Int ?= null
        @ColumnInfo( name ="runtime") var runtime: Int? = null
        @ColumnInfo( name ="status") var status: String ?= null
        @ColumnInfo( name ="tagline") var tagline: String? = null
        @ColumnInfo( name ="video") var video: Boolean ?= null
        @ColumnInfo( name ="vote_average") var vote_average: Float ?= null
        @ColumnInfo( name ="vote_count") var vote_count: Int ?= null
}