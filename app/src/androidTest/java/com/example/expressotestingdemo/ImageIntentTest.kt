package com.example.expressotestingdemo

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.bumptech.glide.load.engine.Resource
import com.example.expressotestingdemo.ui.activities.MovieActivity
import com.example.expressotestingdemo.ui.activities.SecondaryActivity
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ImageIntentTest {

    // Special test rule if you ever testing intents, prepare test class and tell him to prepare yourself as we are going to test intents here.
    @get:Rule
    val intentTestRule = IntentsTestRule(MovieActivity::class.java)

    @get:Rule
    var mRuntimePermissionRule = GrantPermissionRule.grant(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Test
    fun validateGalleryIntent(){
        val activityScenario=ActivityScenario.launch(MovieActivity::class.java)
        onView(withId(R.id.main)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        //Given and setup (NOTE: Hamcrest import for matcher)
        //Hamcrest import for matcher.
        val expectedIntent : Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )

        val activityResult = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult) //TELLING WHAT IS EXPECTED

        //Execute and verify
        onView(withId(R.id.movieImageView)).perform(click())
        intended(expectedIntent) //DID ACTUALLY HAPPENED WHAT WE INTENDED
    }

    /**
     * Note that we cant test with an image of gallery as
     * each person gallery has a different images. So we take launcher image from our android project.
     * DONO WORRY IF NOT UNDERSTOOD, Directly copy and will work everywhere.
     * */
    private fun createGalleryPickActivityResultStub(): Instrumentation.ActivityResult {
        val resources: Resources = InstrumentationRegistry.getInstrumentation().context.resources
        val imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                    resources.getResourcePackageName(R.drawable.ic_launcher_background) + '/' +
                    resources.getResourceTypeName(R.drawable.ic_launcher_background) + '/' +
                    resources.getResourceEntryName(R.drawable.ic_launcher_background)
        )
        val resultIntent = Intent()
        resultIntent.setData(imageUri)
        return Instrumentation.ActivityResult(RESULT_OK, resultIntent)
    }

}