package com.theintsuhtwe.enjoywithme.network.response

import com.theintsuhtwe.enjoywithme.data.vos.CastAndCrewVO
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO
import com.theintsuhtwe.enjoywithme.utils.*
import io.reactivex.Observable
import retrofit2.http.*

interface MoviesApi {

    @GET(GET_UPCOMING_MOVIES)
    fun getAllMovies(@Query(API_KEY) accessToken : String)
            : Observable<GetAllMoviesResponse>

    @GET(GET_POPULAR_MOVIES)
    fun getAllPopularMovies(@Query(API_KEY) accessToken : String)
            : Observable<GetAllPopularMoviesResponse>

    @GET(GET_NOW_PLAYING_MOVIES)
    fun getAllNowPlayingMovies(@Query(API_KEY) accessToken : String)
            : Observable<GetAllNowPlayingMoviesResponse>

    @GET(GET_TOP_RATED_MOVIES)
    fun getAllTopRatedMovies(@Query(API_KEY) accessToken : String,
                               @Query("pagwith_genrese") title : String
    )
            : Observable<GetAllTopRatedMoviesResponse>


    @GET(GET_ACTORS)
    fun getAllActors(@Query(API_KEY) accessToken : String)
            : Observable<GetAllActorsResponse>


    @GET("genre/movie/list")
    fun getAllGeners(@Query(API_KEY) accessToken : String)
            : Observable<GetAllGenersResponse>

    @GET("movie/{movie_id}/videos")
    fun getVideoByMovieId(
        @Path("movie_id") movieId: Int,
        @Query(API_KEY) accessToken: String

    )
            : Observable<GetAllVideoResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetailsById(
        @Path("movie_id") movieId:Int,
        @Query("api_key")apiKey: String): Observable<MovieDetailVO>

    @GET("movie/{movie_id}/credits")
    fun getCastAndCrew(
        @Path("movie_id")movieId: Int,
        @Query("api_key")apiKey: String) :Observable<CastAndCrewVO>

    @GET("discover/movie")
    fun getWithGenerList(@Query("api_key")apiKey: String,
                         @Query("with_genres")with_genres: String
    ):Observable<GetMovieWithGenerResponse>

}