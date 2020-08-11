package com.theintsuhtwe.enjoywithme.data.dummy

import com.theintsuhtwe.enjoywithme.data.vos.*

fun getMovies()  : List<MovieDetailVO>{
    val movieOne = MovieDetailVO()
    
        movieOne.adult = false 
        movieOne.backdrop_path = "/itiz2OBK4ns6XT0ufXtusojmMt9.jpg"
        movieOne.budget = 0
        movieOne.genres = arrayListOf(

        )
        val geners = GenersVO()
        geners.id = 11
        geners.name = "Animation"
        movieOne.genres.add(geners)
        movieOne.id = 730239 
        movieOne.imdb_id = null 
        movieOne.original_language = "en"
        movieOne.original_title = "Manohar & I"
        movieOne.overview = "Two solitary individuals meet each other every day in the city of Calcutta and share the stories of their imaginary life. But one day when death makes an appearance  the truth is revealed.movieOne."
        movieOne.popularity = 3.0.toFloat()
        movieOne.poster_path = null
        movieOne.production_countries = arrayListOf()
        val pro = ProductionCountryVO()
        pro.name = "Korea"
        pro.id = 24
        movieOne.production_countries.add(pro)
        movieOne.release_date = "2020 Dec 25"
        movieOne.revenue = 0 
        movieOne.runtime = 118 

        movieOne.video = false 
        movieOne.vote_average = 30.0.toFloat()
        movieOne.vote_count = 3

    return arrayListOf(movieOne)
}

fun getPopularMovies() : List<PopularMoviesVO>{
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

    return arrayListOf(movieOne)
}

fun getSliderMovies() : List<MoviesVO>{
    val movieOne =MoviesVO()
    movieOne.backdropPath = "/itiz2OBK4ns6XT0ufXtusojmMt9.jpg"

    movieOne.id = 730239

    movieOne.original_language = "en"
    movieOne.title = "Manohar & I"
    movieOne.overView = "Two solitary individuals meet each other every day in the city of Calcutta and share the stories of their imaginary life. But one day when death makes an appearance  the truth is revealed.movieOne."
    movieOne.popularity = 3.0
    movieOne.posterPath =  "/itiz2OBK4ns6XT0ufXtusojmMt9.jpg"
    movieOne.releaseDate = "2020 Dec 25"


    movieOne.voteAvagere = 9.7
    movieOne.vote_count = 31

    return arrayListOf(movieOne,movieOne,movieOne,movieOne,movieOne)
}

fun getTopRatedMovies() : List<TopRatedVO>{
    val movieOne = TopRatedVO()
    movieOne.backdrop_path = "/itiz2OBK4ns6XT0ufXtusojmMt9.jpg"

    movieOne.id = 703771
    movieOne.popularity = 133.719.toFloat()
    movieOne.original_language = "en"
    movieOne.original_title = "Manohar & I"
    movieOne.overview = "Two solitary individuals meet each other every day in the city of Calcutta and share the stories of their imaginary life. But one day when death makes an appearance  the truth is revealed.movieOne."
    movieOne.popularity = 3.0.toFloat()
    movieOne.poster_path = null
    movieOne.release_date = "2020 Dec 25"

    movieOne.video = false
    movieOne.vote_average = 35.0.toFloat()
    movieOne.vote_count = 49

    return arrayListOf(movieOne)
}

fun getNowPlayingMovies()  : List<NowPlayingVO>{
    val movieOne = NowPlayingVO()
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

    return arrayListOf(movieOne)
}

fun getCasts() : List<CastVO> {
    val castOne = CastVO()
    castOne.cast_id  = 0
    castOne.character  = "Elle Evans"
    castOne.credit_id  = "5903d1ddc3a3684a68001de8"
    castOne.gender  = 1
    castOne.id  = 125025
    castOne.name  = "Joey King"
    castOne.order  = 0
    castOne.profile_path  = "/jUuKlP1hjPJ6R0d6MhUytr85oRL.jpg"
    return arrayListOf(castOne)

}

fun getCrew () : List<CrewVO>{

    val crewOne = CrewVO()
    crewOne.credit_id= "5b7559109251411d8700dacd"
    crewOne.department= "Production"
    crewOne.gender= 0
    crewOne.id= 2108570
    crewOne.job= "Producer"
    crewOne.name= "Andrew Cole-Bulgin"
    crewOne.profile_path= "/7hctL4FFc7a7bN6TnM6Uc6Iuqwh.jpg"

    return arrayListOf(crewOne)

}

fun getCastAndCrew() : List<CastAndCrewVO>{
    val castAndCrew = CastAndCrewVO()
    castAndCrew.id = 213456
    val crewOne = CrewVO()
    crewOne.credit_id= "5b7559109251411d8700dacd"
    crewOne.department= "Production"
    crewOne.gender= 0
    crewOne.id= 21570
    crewOne.job= "Producer"
    crewOne.name= "Andrew Cole-Bulgin"
    crewOne.profile_path= "/7hctL4FFc7a7bN6TnM6Uc6Iuqwh.jpg"
    val castOne = CastVO()
    castOne.cast_id  = 0
    castOne.character  = "Elle Evans"
    castOne.credit_id  = "5903d1ddc3a3684a68001de8"
    castOne.gender  = 1
    castOne.id  = 125025
    castOne.name  = "Joey King"
    castOne.order  = 0
    castOne.profile_path  = "/jUuKlP1hjPJ6R0d6MhUytr85oRL.jpg"
    castAndCrew.cast = arrayListOf(castOne)
    castAndCrew.crew = arrayListOf(crewOne)
    return arrayListOf(castAndCrew)
}

fun getTabTitle () : List<GenersVO>{
    val titleOne = GenersVO()
    titleOne.id = 1
    titleOne.name = "Animation"
    val titleTwo = GenersVO()
    titleTwo.id = 2
    titleTwo.name = "Drama"
    val titleThree = GenersVO()
    titleThree.id = 3
    titleThree.name = "Animation"
    val titleFour = GenersVO()
    titleFour.id = 4
    titleFour.name = "Drama"
    val title = GenersVO()
    title.id = 5
    title.name = "Animation"
    return arrayListOf(title, titleOne, titleTwo, titleThree, titleFour)
}

fun getActor() : List<ActorVO>{
    val actor = ActorVO()
    actor.popularity = 154.36
    actor.name = "Alison Jaye Horowitz"
    actor.id = 1362223
    actor.profilePath = "/iEWtgDu0OweicGOl1rxybzCaota.jpg"
    return arrayListOf(actor)

}

