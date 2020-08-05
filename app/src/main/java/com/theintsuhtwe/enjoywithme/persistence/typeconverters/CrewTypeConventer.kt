package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.CrewVO

class CrewTypeConverter {
    @TypeConverter
    fun toTorrent(json: String): ArrayList<CrewVO> {
        val type = object : TypeToken<ArrayList<CrewVO>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toString(crew: ArrayList<CrewVO>): String {
        return Gson().toJson(crew)
    }
}