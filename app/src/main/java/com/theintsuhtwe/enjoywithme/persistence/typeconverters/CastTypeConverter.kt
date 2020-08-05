package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.CastVO
import com.theintsuhtwe.enjoywithme.data.vos.CrewVO

class CastTypeConverter {
    @TypeConverter
    fun toString(commentList: List<CastVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<CastVO> {
        val commentListType = object : TypeToken<ArrayList<CastVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}