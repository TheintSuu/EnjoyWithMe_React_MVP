package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.utils.first
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToYouTubeLink {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnPlayMovie_navigateToYoutubeLink(){
       onView(first<View>(withId(R.id.ivPlay)))
           .perform(click())


        //navigate to youtube link from movie play btn


        // Verify that an intent to the dialer was sent with the correct action, phone
        // number and package.
//        val receivedIntent =
//            Iterables.getOnlyElement(Intents.getIntents())
//        assertThat(receivedIntent).hasAction(Intent.ACTION_CALL)
//        assertThat(receivedIntent).hasData(com.theintsuhtwe.enjoywithme.uitests.movielist.GoToYouTubeLink.Uri_Link)
        intended(
            allOf(
                hasComponent(hasShortClassName(".MainActivity")),
                hasAction(Intent.ACTION_VIEW),
                hasData(com.theintsuhtwe.enjoywithme.uitests.movielist.GoToYouTubeLink.Uri_Link)
            )
        )
    }

    companion object {
        private const val YOUTUBE_LINK = "f8t8LE28YUQ"

        const val YOUTUBE_URL = "https://www.youtube.com/watch?v="

        private val Uri_Link = YOUTUBE_URL + YOUTUBE_LINK

    }
}