package com.theintsuhtwe.enjoywithme.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.enjoywithme.data.model.ActorModelImpl
import com.theintsuhtwe.enjoywithme.data.model.MovieDetailModelImpl
import com.theintsuhtwe.enjoywithme.data.model.MoviesModelImpl
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView


class DetailPresenterImpl : DetailPresenter , AbstractBasePresenter<DetailView>() {

    private val mMoviesModel  = MoviesModelImpl

    private val mActorModel  = ActorModelImpl

    private val mMovieDetailModel = MovieDetailModelImpl



    override fun onUiReady(movieId: Int, lifeCycleOwner: LifecycleOwner) {
        getAllMovieDetial(movieId, lifeCycleOwner)
    }

    override fun onTabSelected(lifeCycleOwner: LifecycleOwner, title: String) {

    }

    override fun onTapActorItem(value: Int) {

    }



    private fun requestAllActors(lifeCycleOwner: LifecycleOwner) {


    }

    private fun requestAllCreator(lifeCycleOwner: LifecycleOwner) {


    }

    private fun getAllMovieDetial(movieId: Int, lifeCycleOwner: LifecycleOwner){
//        mMovieDetailModel.getMovieDetail(movieId, onError = {
//        }).observe(lifeCycleOwner, Observer {
//            mView?.displayAllMovieDetail(it)
//        })
        mMovieDetailModel.getMovieDetail(movieId) {

        }.observe(lifeCycleOwner, Observer {
            it?.let {
                mView?.displayAllMovieDetail(it)
            } ?: arrayListOf<MovieDetailVO>()

        })
        mMovieDetailModel.getMovieDetailsAndSaveToDatabase(movieId,
            onSuccess = {},
            onError = {
                Log.d("Error","hello")
        })
        mMovieDetailModel.getAllCastAndCrewFromApiSaveDataBase(movieId, onSuccess = {},
        onError = {

        })

        mMovieDetailModel.getAllCastAndCrew(movieId, onError = {

        }).observe(lifeCycleOwner, Observer { castAndCrew ->
            castAndCrew?.let{
            mView?.displayActorsList(castAndCrew.cast)
            mView?.displayCreatorsList(castAndCrew.crew)
        }

        })
    }





}