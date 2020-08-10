package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.shared.BasePresenter
import com.theintsuhtwe.enjoywithme.delegate.ActorAndCrewItemDelegate
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView

interface DetailPresenter : ActorAndCrewItemDelegate, BasePresenter<DetailView> {
    fun onUiReady(movieId : Int, lifeCycleOwner: LifecycleOwner)

    fun onTabSelected(lifeCycleOwner: LifecycleOwner, title : String)


}
