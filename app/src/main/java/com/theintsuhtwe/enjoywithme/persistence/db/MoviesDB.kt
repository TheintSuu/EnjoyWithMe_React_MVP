package com.theintsuhtwe.enjoywithme.persistence.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theintsuhtwe.enjoywithme.data.vos.*
import com.theintsuhtwe.enjoywithme.persistence.daos.*

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-02-14.
 */

@Database(entities = [MoviesVO::class, ActorVO::class, PopularMoviesVO::class, TopRatedVO::class,
    NowPlayingVO::class, GenersVO::class,
    MovieDetailVO::class, CastAndCrewVO::class], version = 20, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_Movies_X.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun MoviesDao(): MoviesDao
    abstract fun TopRatedVODao(): TopRateMovieDao
    abstract fun PopularMoviesDao(): PopularMoviesDao
    abstract fun  NowPlayingMovieDao(): NowPlayingMovieDao
    abstract fun ActorsDao(): ActorDao
    abstract fun GenersDao(): GenersDao
    abstract fun CrewAndCrewDao() : CastAndCrewDao
    abstract fun MovieDetailDao () : MovieDetailDao
}