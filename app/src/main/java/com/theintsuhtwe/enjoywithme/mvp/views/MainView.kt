package com.theintsuhtwe.enjoywithme.mvp.views

import com.example.shared.BaseView
import com.theintsuhtwe.enjoywithme.data.vos.*

interface MainView : BaseView {
    fun displayMoviesList(newsList: List<MoviesVO>)//UpComing Image Slider

    fun navigateToMoviesDetails(newsId: Int)

    fun displayAcotrList(newList : List<ActorVO>)//Actor Recycler

    fun displayMovieListByCaterogry(newsList: List<TopRatedVO>) //tab

    fun dispalyShowCaseMovieList(newsList : List<NowPlayingVO>) // show case

    fun dispalyPopularMovieList(newsList : List<PopularMoviesVO>) // show case

    fun displayGenersList(newList : List<GenersVO>)

    fun navigateToVideo(key : List<String>)



}