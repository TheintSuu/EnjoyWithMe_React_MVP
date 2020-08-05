package com.theintsuhtwe.enjoywithme.mvp.presenters.impls

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.theintsuhtwe.enjoywithme.adapters.*
import com.theintsuhtwe.enjoywithme.data.dummy.*
import com.theintsuhtwe.enjoywithme.data.model.*
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {
    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mPopularModel: PopularMovieImpl

    private lateinit var mShowCasedModel: NowPlayingMovieImpl

    private lateinit var mAcotrModel: ActorModelImpl


    private lateinit var mTabModel: TopRatedMovieImpl

    private lateinit var mSlider : MoviesModelImpl


    private var tabLayoutTitleList : List<String> ?= null

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MoviesModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        ActorModelImpl.initDatabase(ApplicationProvider.getApplicationContext() )
        TopRatedMovieImpl.initDatabase(ApplicationProvider.getApplicationContext() )
        NowPlayingMovieImpl.initDatabase(ApplicationProvider.getApplicationContext() )
        PopularMovieImpl.initDatabase(ApplicationProvider.getApplicationContext() )
        GenersModelImpl.initDatabase(ApplicationProvider.getApplicationContext() )
        MovieDetailModelImpl.initDatabase(ApplicationProvider.getApplicationContext() )

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTopRatedModel = this.mTabModel
        mPresenter.mMoviesModel = this.mSlider
        mPresenter.mPopularMovieModel = this.mPopularModel
        mPresenter.mShowcaseModel = this.mShowCasedModel
        mPresenter.mActorModel = this.mAcotrModel
    }

    @Test
    fun onTtapMovieItem_callNavigateTMovieDetailScreen(){
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
        val imageView = ImageView(ApplicationProvider.getApplicationContext())
        mPresenter.onTapMovieItem(movieOne.id)
        verify {
            mView.navigateToMoviesDetails(movieOne.id)
        }
    }

    @Test
    fun onUIReady_callDisplayMovieList() {
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onUiReady(lifeCycleOwner)
        verify {
            mView.dispalyPopularMovieList(getPopularMovies())

            mView.dispalyShowCaseMovieList(getNowPlayingMovies())

            mView.displayMovieListByCaterogry(getTopRatedMovies())

            mView.displayAcotrList(getActor())

            mView.displayMoviesList(getSliderMovies())
        }
    }
}