package com.theintsuhtwe.enjoywithme.uitests.movielist

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.activites.MainActivity
import com.theintsuhtwe.enjoywithme.utils.first
import junit.framework.TestCase.assertEquals
import org.hamcrest.core.AllOf.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToYouTubeLink {
    private val activityTestRule = IntentsTestRule<MainActivity>(MainActivity::class.java)






    @Before
    open fun setUp(){
        var grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant("android.permission.INTERNET")
        activityTestRule.launchActivity(Intent())

        //val result: ActivityResult = getTestInent()



    }

    @Test
    fun tapOnPlayMovie_navigateToYoutubeLink(){

       onView(first<View>(withId(R.id.ivPlay)))
           .perform(click())

        Thread.sleep(2000)




        assertEquals(true,
            intended(
                allOf(
                    hasPackage("com.android.browser"),
                    hasAction(Intent.ACTION_VIEW),
                    hasData(com.theintsuhtwe.enjoywithme.uitests.movielist.GoToYouTubeLink.Uri_Link)
                )
            )
        )


    }

    fun getTestInent() : ActivityResult {
        val youTubeIntent : Intent = Intent(
            Intent.ACTION_VIEW,

            Uri.parse(Uri_Link)
        )
       return ActivityResult(Activity.RESULT_OK, youTubeIntent)
    }




    companion object {
        private const val YOUTUBE_LINK = "f8t8LE28YUQ"

        const val YOUTUBE_URL = "https://www.youtube.com/watch?v="

        private val Uri_Link = YOUTUBE_URL + YOUTUBE_LINK

    }
}