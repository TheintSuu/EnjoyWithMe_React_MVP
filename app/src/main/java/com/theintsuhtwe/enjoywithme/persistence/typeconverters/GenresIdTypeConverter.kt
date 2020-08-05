package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

class GenresIdTypeConverter {
    fun toString(commentList: ArrayList<Int>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<Int> {
        val commentListType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}