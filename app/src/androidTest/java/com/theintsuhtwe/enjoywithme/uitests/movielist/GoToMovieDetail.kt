package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.views.viewholders.PopularMovieViewHolder
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetail {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnMovie_navigateToMovieDetails(){
        onView(withId(R.id.rvPopularMovies))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(0, click())

            )
        onView(withId(R.id.tvOriginalTile))
            .check(matches(isDisplayed()))
    }

}