package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class CrewVO {
    @ColumnInfo(name =  "credit_id")
    var credit_id: String? = null
    @ColumnInfo(name =  "job")
    var job: String? = null
    @ColumnInfo(name ="id")
    var id: Int? = null
    @ColumnInfo(name ="gender")
    var gender: Int? = null
    @ColumnInfo(name ="name")
    var name: String? = null
    @ColumnInfo(name ="department")
    var department: String? = null
    @ColumnInfo(name ="profile_path")
    @SerializedName("profile_path")
    var profile_path: String? = null

}