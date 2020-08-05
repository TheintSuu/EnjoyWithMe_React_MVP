package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.enjoywithme.data.model.*
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mMoviesModel = MoviesModelImpl
    var mActorModel = ActorModelImpl
    var mShowcaseModel = NowPlayingMovieImpl
    var mTopRatedModel = TopRatedMovieImpl
    var mPopularMovieModel = PopularMovieImpl
    var mGenersModel = GenersModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        requestAllMovies(lifeCycleOwner)

    }

    override fun onTabSelected(lifeCycleOwner: LifecycleOwner, title: String) {
        requestAllMoviesByCategory(lifeCycleOwner, title)
    }


    override fun onTapMovieItem(value: Int) {
        mView?.navigateToMoviesDetails(value)
    }

    override fun onTapVideoPlay(value: Int) {
        requestAllVideo(value)
    }

    override fun onTapActorItem(value: Int) {
        mView?.navigateToMoviesDetails(value)
    }

    override fun onTapVideoView(id: Int) {
        requestAllVideo(id)
    }


    private fun requestAllMovies(lifeCycleOwner: LifecycleOwner) {
//
        mMoviesModel.getAllMovies(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayMoviesList(it)
        })


        mPopularMovieModel.getAllPopularMovieList(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.dispalyPopularMovieList(it)
        })

//        mTopRatedModel.getAllTopMovieList  (onError = {
//        }).observe(lifeCycleOwner, Observer {
//            mView?.displayMovieListByCaterogry(it)
//        })
//
//        mTopRatedModel.getTopMovieFromApiSaveToDB(
//            "",
//            onSuccess = {
//
//            },
//           onError = {
//
//            }
//        )
//
        mMoviesModel.getAllMoviesFromApiAndSaveToDatabase(
            onSuccess = {

            },
            onError = {

            }
        )

        mPopularMovieModel.getAllPopularMovieFromApiSaveToDatabase(
            onSuccess = {

            },
            onError = {

            }
        )

        mShowcaseModel.getAllNowPlayingMovieFromApiSaveToDatabase(
            onSuccess = {

            },
            onFailure = {

            }
        )

        mActorModel.getPopularActorFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

        mGenersModel.getPopularGenersFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

        mShowcaseModel.getAllNowPlayingMovieList(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.dispalyShowCaseMovieList(it)
        })

        mActorModel.getAllActorList(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayAcotrList(it)
        })

        mGenersModel.getAllGenersList(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayGenersList(it)
        })

    }

    private fun requestAllMoviesByCategory(lifeCycleOwner: LifecycleOwner, title: String) {

        mTopRatedModel.getTopMovieFromApiSaveToDB(
            title,
            onSuccess = {
                //  mView?.displayMovieListByCaterogry(it)
            },
            onError = {

            }
        )

        mTopRatedModel.getAllTopMovieList(
            onError = {
            }).observe(lifeCycleOwner, Observer {
            mView?.displayMovieListByCaterogry(it)
        })
    }

    private fun requestAllVideo(id: Int) {
        mMoviesModel.getVideoByMovieById(
            id,
            onSuccess = {
                val keyList = it.map { it.key }.take(1)
                mView?.navigateToVideo(keyList)
            },
            onError = { }
        )
    }


}