package com.theintsuhtwe.enjoywithme.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO
import com.theintsuhtwe.enjoywithme.persistence.daos.*
import com.theintsuhtwe.enjoywithme.persistence.db.MoviesDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class Database {
    private lateinit var movieDao : MoviesDao
    private lateinit var popularDao : PopularMoviesDao
    private lateinit var nowPlayingMovieDao : NowPlayingMovieDao
    private lateinit var topRatedMovieDao : TopRateMovieDao
    private lateinit var actorDao: ActorDao
    private lateinit var movieDetailDao : MovieDetailDao
    private lateinit var castAndCrewDao : CastAndCrewDao
    private lateinit var genersDao : GenersDao
    private lateinit var movieDB : MoviesDB

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        movieDB = Room.inMemoryDatabaseBuilder(
            context, MoviesDB::class.java
        ).build()
        movieDao = movieDB.MoviesDao()
        popularDao = movieDB.PopularMoviesDao()
        topRatedMovieDao = movieDB.TopRatedVODao()
        movieDetailDao = movieDB.MovieDetailDao()
        nowPlayingMovieDao = movieDB.NowPlayingMovieDao()
        castAndCrewDao = movieDB.CrewAndCrewDao()
        actorDao = movieDB.ActorsDao()

    }

    @After
    fun closeDb(){
        movieDB.close()
    }


    @Test
    fun insertIntoDatabaseTest(){
        val movieOne = PopularMoviesVO()
        movieOne.backdrop_path = "/itiz2OBK4ns6XT0ufXtusojmMt9.jpg"

        movieOne.id = 730239

        movieOne.original_language = "en"
        movieOne.original_title = "Manohar & I"
        movieOne.overview = "Two solitary individuals meet each other every day in the city of Calcutta and share the stories of their imaginary life. But one day when death makes an appearance  the truth is revealed.movieOne."
        movieOne.popularity = 3.0.toFloat()
        movieOne.poster_path = null
        movieOne.release_date = "2020 Dec 25"

        movieOne.video = false
        movieOne.vote_average = 35.0.toFloat()
        movieOne.vote_count = 31
        popularDao.insertPopularMovieList(arrayListOf(movieOne))

        assert(popularDao.getPopularById(movieOne.id).value?.id == movieOne.id)
    }
}