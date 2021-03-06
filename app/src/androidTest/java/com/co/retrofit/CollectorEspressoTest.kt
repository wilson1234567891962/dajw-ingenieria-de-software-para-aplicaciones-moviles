package com.co.retrofit

import com.co.retrofit.app.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.TestUtils.atPosition
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CollectorEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpenTheApp_heShouldLookTheCollector() {
        onView(withId(R.id.navigation_collector))
            .perform(click())
        onView(withId(R.id.collectorRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
    }

    @Test
    fun wheTheUserOpenTheApp_heClickInItemArtistAndGoBackTheFistOption_heShouldLookTheCollectorAgain() {
        onView(withId(R.id.navigation_collector))
            .perform(click())
        onView(withId(R.id.collectorRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
        onView(withId(R.id.navigation_artist))
            .perform(click())
        onView(withId(R.id.navigation_collector))
            .perform(click())
            .check(matches(isDisplayed()))
        onView(withId(R.id.collectorRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
    }

    @Test
    fun wheTheUserOpenTheApp_heClickInAlbumThenArtistAndGoBackTheFistOption_heShouldLookTheCollectorAgain() {
        onView(withId(R.id.navigation_collector))
            .perform(click())
        onView(withId(R.id.collectorRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
        onView(withId(R.id.navigation_album))
            .perform(click())
            .check(matches(isDisplayed()))
        onView(withId(R.id.navigation_artist))
            .perform(click())
        onView(withId(R.id.navigation_collector))
            .perform(click())
            .check(matches(isDisplayed()))
        onView(withId(R.id.collectorRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))

    }


}
