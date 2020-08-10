package com.theintsuhtwe.enjoywithme.mvp.views

import com.example.shared.BaseView
import com.theintsuhtwe.enjoywithme.data.vos.*

interface DetailView : BaseView {
    fun displayActorsList(newsList: ArrayList<CastVO>)

    fun displayCreatorsList(newsList: ArrayList<CrewVO>)

    fun displayAllMovieDetail(detail: MovieDetailVO)





}