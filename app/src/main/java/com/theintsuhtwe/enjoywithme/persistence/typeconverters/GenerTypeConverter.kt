package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO

class GenerTypeConveter {
    @TypeConverter
    fun toString(commentList: ArrayList<GenersVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<GenersVO> {
        val commentListType = object : TypeToken<ArrayList<GenersVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}