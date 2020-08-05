package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "actor")
 class ActorVO {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "gender")
    var gender: Int = 0
    @ColumnInfo(name = "profile_path")
    @SerializedName("profile_path")
    var profilePath: String = ""
    @ColumnInfo(name = "adult")
    var adultStatus: Boolean = false
    @ColumnInfo(name = "popularity")
    var popularity: Double = 0.0
    @ColumnInfo(name = "known_for_department")
    var knownForDepartment: String = ""

}

