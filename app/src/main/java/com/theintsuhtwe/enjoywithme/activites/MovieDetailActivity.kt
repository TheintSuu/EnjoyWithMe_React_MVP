package com.theintsuhtwe.enjoywithme.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.adapters.ActorItemAdapter
import com.theintsuhtwe.enjoywithme.adapters.CastAdapter
import com.theintsuhtwe.enjoywithme.adapters.CreatorItemAdapter
import com.theintsuhtwe.enjoywithme.data.model.MoviesModelImpl
import com.theintsuhtwe.enjoywithme.data.vos.*
import com.theintsuhtwe.enjoywithme.mvp.presenters.DetailPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.DetailPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.view_pod_about_film.*
import kotlinx.android.synthetic.main.view_pod_actor.*
import kotlinx.android.synthetic.main.view_pod_actor.view.*
import kotlinx.android.synthetic.main.view_pod_creator.*
import kotlinx.android.synthetic.main.view_pod_creator.view.*
import kotlinx.android.synthetic.main.view_pod_story_line_btn.*

class MovieDetailActivity :BaseActivity(), DetailView {

    companion object {

        const val NEWS_ID_EXTRA = "News Id Extra"

        fun newItent(context: Context, newsId : Int): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }

    private lateinit var mAcotradapter: CastAdapter


    private lateinit var mCreatorItemAdapter: CreatorItemAdapter

    private lateinit var mPresenter: DetailPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpPresenter()

        setUpRecyclerViews()

        setUpListener()

        val newsId = intent.getIntExtra(NEWS_ID_EXTRA, 0)

        mPresenter.onUiReady(movieId = newsId, lifeCycleOwner = this)

    }


    override fun displayActorsList(newsList: ArrayList<CastVO>) {
        mAcotradapter.setData(newsList.toMutableList())
    }

    override fun displayCreatorsList(newsList: ArrayList<CrewVO>) {
       mCreatorItemAdapter.setData(newsList.toMutableList())
    }


    override fun displayAllMovieDetail(detail: MovieDetailVO) {
        bindData(detail)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerViews(){
        mAcotradapter =  CastAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detailActorLayout.rvActors.layoutManager = linearLayoutManager
        detailActorLayout.rvActors.adapter =  mAcotradapter

        mCreatorItemAdapter =  CreatorItemAdapter(mPresenter)
        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        creatorLayout.rvCreators.layoutManager = linearLayoutManager1
        creatorLayout.rvCreators.adapter = mCreatorItemAdapter
    }

    private  fun bindData(news : MovieDetailVO){
        Glide.with(this)
            .load(IMAGE_BASE_URL+news.poster_path)
            .into(ivMoviesImage)

        tvYear.text = news.release_date!!.substringBefore("-")
        tvVoteAvearage.text = news .vote_average.toString()
        tvVoteCount.text = news.vote_count.toString() + "   VOTES"
        tvMovieTitle.text = news .original_title

        //   createDynamicChip(data.genres,chipGroup)
        tvStoryLines.text = news .tagline
        tvOriginalTile.text = news.original_title

        tvPremiereTile.text = news.release_date

            var result : String = ""
            for(data in  news.genres){
                if(data.name != null){
                    result += data.name
                    result += " "
                }

            }
        tvTypeTile.text = result
        if(news.production_countries.isNotEmpty()){
           tvProductionTile.text = news.production_countries.get(0).name
        }
        tvDescriptiontitle.text = news.overview
    }


    private fun setUpListener(){
        btnBack.setOnClickListener {
            finish()
        }
    }


}