package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.enjoywithme.data.model.*
import com.theintsuhtwe.enjoywithme.data.vos.GenersVO
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mMoviesModel : MoviesModel = MoviesModelImpl
    var mActorModel = ActorModelImpl
    var mShowcaseModel = NowPlayingMovieImpl
    var mTopRatedModel: TopRateMovieModel = TopRatedMovieImpl
    var mPopularMovieModel = PopularMovieImpl
    var mGenersModel: GenersModel = GenersModelImpl

    var genersList: List<GenersVO> = arrayListOf()


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
        })
            .observe(lifeCycleOwner, Observer {
                genersList = it
                mView?.displayGenersList(it)
            })

    }

    private fun requestAllMoviesByCategory(lifeCycleOwner: LifecycleOwner, title: String) {


        val geners = genersList.filter { u ->

            u.name.toString()
                .equals(
                    title.toString()
                )
        }.firstOrNull()


        if (title != null) {
//            mGenersModel.getGenersById(
//                title,
//                onError = {
//                }).observe(lifeCycleOwner, Observer {
//                geners = it

         //   val genreId = geners?.id ?: 12;
            geners?.let { genre ->
                  //  genre.id = 12
                    mTopRatedModel.getTopMovieFromApiSaveToDB(
                        geners.id.toString(),
                        onSuccess = {
                            mView?.displayMovieListByCaterogry(it)
                        },
                        onError = {

                        }
                    )
                } ?: run{

            }
            }




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