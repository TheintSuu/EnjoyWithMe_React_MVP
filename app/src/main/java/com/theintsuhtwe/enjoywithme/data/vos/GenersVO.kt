package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "geners")
class GenersVO {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int ?= null
    @ColumnInfo(name = "name")
    var name : String ?= null
}