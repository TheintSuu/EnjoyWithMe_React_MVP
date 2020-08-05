package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO


@Dao
interface MovieDetailDao{
    @Query("SELECT * FROM movieDetail WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<MovieDetailVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movieDetail: MovieDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieList(news: List<MovieDetailVO>)
}