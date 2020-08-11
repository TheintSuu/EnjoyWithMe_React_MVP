package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.views.viewholders.PopularMovieViewHolder
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieListByGenersId {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)



    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
        assertThat(activityTestRule, notNullValue())
    }

    @Test
    fun tapOnMovie_navigateToSwipeLeft(){

        onView(withId(R.id.tabLayoutProfile))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tabLayoutProfile))
            .perform(swipeLeft())

    }

    @Test
    fun tapOnMovie_nagivateToRecyclerView(){
        onView(allOf(withText("Drama"), isDescendantOfA(withId(R.id.tabLayoutProfile))))
            .perform(click())
            .check(matches(isDisplayed()));


        //assertThat(((MyFragment)mActivity.getAdapter().getCurrentFragment()).getTitle(), Matchers.equalTo("test5"));
        //assertThat(((MyFragment)mActivity.getAdapter().getCurrentFragment()).getTitle(), Matchers.equalTo("test5"));
    }
    }




