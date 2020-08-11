package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO

@Dao
interface GenersDao {

    @Query("SELECT * FROM geners")
    fun getAllgeners(): LiveData<List<GenersVO>>

    @Query("SELECT * FROM geners WHERE name = :noteId")
    fun getgenersById(noteId: String) : LiveData<GenersVO>

    @Query("DELETE FROM geners")
    fun deleteAll()

    @Delete
    fun deletegeners(note: GenersVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertgeners(noteVO: GenersVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllgeners(geners: List<GenersVO>)
}