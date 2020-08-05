package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO


class MovieTypeConverter {
    @TypeConverter
    fun toString(MoviesVO: MoviesVO): String {
        return Gson().toJson(MoviesVO)
    }

    @TypeConverter
    fun toMovies(MoviesJson: String): MoviesVO {
        val MoviesType = object : TypeToken<MoviesVO>() {}.type
        return Gson().fromJson(MoviesJson, MoviesType)
    }
}