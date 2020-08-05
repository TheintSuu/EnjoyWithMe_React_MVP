package com.theintsuhtwe.enjoywithme.persistence.daos
import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO

@Dao
interface TopRateMovieDao {
    @Query("SELECT * FROM topMovie")
    fun getAllTopRateMovie() : LiveData<List<TopRatedVO>>

    @Query("SELECT * FROM topMovie WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<TopRatedVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovie(topRateMovie: TopRatedVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovieList(topRateMovie: List<TopRatedVO>)

    @Query("Delete From topMovie")
    fun deleteAll()
}