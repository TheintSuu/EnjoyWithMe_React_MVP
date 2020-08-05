package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class ProductionCountryVO {
     @ColumnInfo(name ="name")var name: String ? = null
     @ColumnInfo(name ="id")var id: Int ? = null
     @ColumnInfo(name ="logo_path")var logo_path : String ? = null
     @ColumnInfo(name ="origin_country")var origin_country: String ? = null

}