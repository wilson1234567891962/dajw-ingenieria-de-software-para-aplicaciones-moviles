package com.co.retrofit

import androidx.recyclerview.widget.RecyclerView
import com.co.retrofit.app.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.TestUtils.atPosition
import com.co.retrofit.TestUtils.hasValueEqualTo
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DetailEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClicksOneAlbum_AndHeShouldLookTheDetail() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.back_detail_album))
            .perform(click())
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
    }

    @Test
    fun wheTheUserOpensTheApp_heClicksOneAlbum_AndHeClicksOnBack() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.back_detail_album))
            .perform(click())
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
    }

    @Test
    fun wheTheUserOpensTheApp_heClicksOneAlbum_AndTryToLookTheAlbumList() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.record_album))
            .perform(swipeUp())
        onView(withId(R.id.description))
            .perform(swipeUp())
        onView(withId(R.id.title_list_second))
            .perform(swipeUp());
        onView(withId(R.id.rv_album_detail_list))
            .check(matches(atPosition(0, hasDescendant(withText("5:05 m")))))
    }
}
