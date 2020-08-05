package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO


@Dao
interface PopularMoviesDao {
    @Query("SELECT * FROM popularMovie")
    fun getAllPopularMovie() : LiveData<List<PopularMoviesVO>>

    @Query("SELECT * FROM popularMovie WHERE id = :movieId")
    fun getPopularById(movieId :Int) : LiveData<PopularMoviesVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(topRateMovie: PopularMoviesVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieList(topRateMovie: List<PopularMoviesVO>)

    @Query("SELECT * FROM popularMovie ORDER BY id Desc LIMIT 5")
    fun getPosterPath():LiveData<List<PopularMoviesVO>>
}