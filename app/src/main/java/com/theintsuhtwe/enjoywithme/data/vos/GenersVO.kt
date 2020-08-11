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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GenersVO

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }


}