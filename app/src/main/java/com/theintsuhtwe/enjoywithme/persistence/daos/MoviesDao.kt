package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO



@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<MoviesVO>>

    @Query("SELECT * FROM movies WHERE id = :noteId")
    fun getMoviesById(noteId: Int) : LiveData<MoviesVO>

    @Query("DELETE FROM movies")
    fun deleteAll()

    @Delete
    fun deleteMovies(note: MoviesVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(noteVO: MoviesVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(Movies: List<MoviesVO>)
}