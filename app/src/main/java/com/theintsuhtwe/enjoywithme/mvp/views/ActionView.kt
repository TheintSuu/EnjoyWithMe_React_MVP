package com.theintsuhtwe.enjoywithme.mvp.views

import com.example.shared.BaseView
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

interface ActionView : BaseView {
    fun displayMoviesList(newsList: List<MoviesVO>)
    fun navigateToMoviesDetails(newsId: Int)

}