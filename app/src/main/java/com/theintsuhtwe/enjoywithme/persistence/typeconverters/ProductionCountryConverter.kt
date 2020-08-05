package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.ProductionCountryVO

class ProductionCountryConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<ProductionCountryVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<ProductionCountryVO> {
        val commentListType = object : TypeToken<ArrayList<ProductionCountryVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}