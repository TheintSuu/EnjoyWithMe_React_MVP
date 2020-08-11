package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.isInternal
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.views.viewholders.PopularMovieViewHolder
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetail {
    private val activityTestRule = IntentsTestRule<MainActivity>(MainActivity::class.java)



    @Before
     fun setUp(){
        activityTestRule.launchActivity(Intent())
        intending(not(isInternal())).respondWith(
            Instrumentation.ActivityResult(
                Activity.RESULT_OK,
                null
            )
        )
    }

    @Test
    fun tapOnMovie_navigateToMovieDetails(){
        onView(withId(R.id.rvPopularMovies))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(0, click())

            )
//        val resultData =  MovieDetailActivity.newItent(activityTestRule.activity!!, 563)
//
//        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
     //   intending(toPackage("com.theintsuhtwe.enjoywithme.activites")).respondWith(result)
        onView(withId(R.id.tvOriginalTile))
            .check(matches(isDisplayed()))
    }




}