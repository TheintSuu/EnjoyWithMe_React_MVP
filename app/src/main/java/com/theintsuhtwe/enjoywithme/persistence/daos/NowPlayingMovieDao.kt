package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO


@Dao
interface NowPlayingMovieDao {
    @Query("SELECT * FROM NowPlaying")
    fun getAllNowPlaying() : LiveData<List<NowPlayingVO>>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<NowPlayingVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingrMovie(nowPlayingMovie: NowPlayingVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingMovieList(nowPlayingMovie: List<NowPlayingVO>)
}