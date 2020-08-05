package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.CastTypeConverter
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.CrewTypeConverter

@Entity(tableName = "castAndCrew")
@TypeConverters(CastTypeConverter::class , CrewTypeConverter::class)
class CastAndCrewVO {
    @PrimaryKey
    @ColumnInfo(name ="id")
    var id: Int ?= null
    @ColumnInfo(name ="crew")
    @SerializedName("crew")
    var crew: ArrayList<CrewVO> = arrayListOf()
    @ColumnInfo(name ="cast")
    @SerializedName("cast")
    var cast: ArrayList<CastVO> = arrayListOf()
}