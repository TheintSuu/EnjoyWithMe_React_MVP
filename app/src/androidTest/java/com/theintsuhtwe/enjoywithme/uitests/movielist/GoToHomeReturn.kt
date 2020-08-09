package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.activites.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_movie_detail.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToHomeReturn {

    private val activityTestRule = ActivityTestRule<MovieDetailActivity>(MovieDetailActivity::class.java)
    private val mainActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
        mainActivityTestRule.launchActivity(Intent())
    }

    @Test
    fun gotToMainScreen(){
        onView(withId(R.id.btnBack)).perform(click())

        onView(withId(R.id.appbarLayout)).check(matches(isDisplayed()))
    }
}