package com.theintsuhtwe.enjoywithme

import android.app.Application
import com.theintsuhtwe.enjoywithme.data.model.*
import com.theintsuhtwe.enjoywithme.persistence.db.MoviesDB

class EnjoyWithMeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        MoviesModelImpl.initDatabase(applicationContext)
        ActorModelImpl.initDatabase(applicationContext)
        TopRatedMovieImpl.initDatabase(applicationContext)
        NowPlayingMovieImpl.initDatabase(applicationContext)
        PopularMovieImpl.initDatabase(applicationContext)
        GenersModelImpl.initDatabase(applicationContext)
        MovieDetailModelImpl.initDatabase(applicationContext)


    }

    private fun deleteAllBurgers() {
        MoviesDB.getDBInstance(applicationContext)
            .ActorsDao()
            .deleteAll()

        MoviesDB.getDBInstance(applicationContext)
            .MoviesDao()
            .deleteAll()


    }

    private fun prepopulateBurgers() {
//        MoviesDB.getDBInstance(applicationContext )
//            .MoviesDao()
//            .insertAllMovies()
//
//        MoviesDB.getDBInstance(applicationContext)
//            .PopularMoviesDao()
//            .insertPopularMovieList()
//
//        MoviesDB.getDBInstance(applicationContext)
//            .NowPlayingMovieDao().insertNowPlayingMovieList()
//
//        MoviesDB.getDBInstance(applicationContext )
//            .TopRatedVODao()
//            .insertTopRateMovieList()
//
//        MoviesDB.getDBInstance(applicationContext)
//            .ActorsDao()
//            .insertAllActor()
    }
}