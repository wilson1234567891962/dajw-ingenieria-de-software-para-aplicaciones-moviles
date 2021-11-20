package com.co.retrofit

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestArtistDetail {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClicksOneArtist_AndHeClicksOnBack() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_artist))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.artistRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("The Cat Empire"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.artistRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.artist_name))
            .check(ViewAssertions.matches(TestUtils.hasValueEqualTo("The Cat Empire")))
        Espresso.onView(ViewMatchers.withId(R.id.back_detail_artist))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.artistRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("The Cat Empire"))
                    )
                )
            )
    }

    @Test
    fun wheTheUserOpensTheApp_heClicksOneArtist_AndSeeTheAlbumsOfArtist() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_artist))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.artistRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        3,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Queen"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.artistRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.artist_name))
            .check(ViewAssertions.matches(TestUtils.hasValueEqualTo("Queen")))
        Espresso.onView(ViewMatchers.withId(R.id.artist_creation_date))
            .perform(ViewActions.swipeUp())
        Espresso.onView(ViewMatchers.withId(R.id.artist_description))
            .perform(ViewActions.swipeUp())

        Espresso.onView(ViewMatchers.withId(R.id.albumsOfArtistRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("A Night at the Opera"))
                    )
                )
            )
    }
}