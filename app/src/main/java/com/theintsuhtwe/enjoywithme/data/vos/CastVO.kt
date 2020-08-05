package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class CastVO {
    @ColumnInfo(name = "cast_id")
    var cast_id: Int? = null
    @ColumnInfo(name = "character")
    var character: String? = null
    @ColumnInfo(name = "credit_id")
    var credit_id: String? = null
    @ColumnInfo(name = "gender")
    var gender: Int? = null
    @ColumnInfo(name = "id")
    var id: Int? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "order")
    var order: Int? = null
    @ColumnInfo(name = "profile_path")  var profile_path: String ?= null
}