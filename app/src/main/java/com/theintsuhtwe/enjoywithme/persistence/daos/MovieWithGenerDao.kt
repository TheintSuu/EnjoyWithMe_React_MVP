package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO


@Dao
interface MovieWithGenerDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies() : LiveData<List<MoviesVO>>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun getMovieGenerById(movieId :Int) : LiveData<MoviesVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviewWithGener(movieGener: MoviesVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieWithGenerList(movieWithGener: List<MoviesVO>)
}