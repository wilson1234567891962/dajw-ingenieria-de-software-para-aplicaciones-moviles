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
class TestCollectorDetail {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClicksOneCollector_AndHeClicksOnBack() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_collector))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Manolo Bellon"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.collector_email))
            .check(ViewAssertions.matches(TestUtils.hasValueEqualTo("manollo@caracol.com.co")))
        Espresso.onView(ViewMatchers.withId(R.id.back_detail_collector))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Manolo Bellon"))
                    )
                )
            )
    }

    @Test
    fun wheTheUserOpensTheApp_heClicksOneColector_AndSeeTheAlbumsOfCollector() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_collector))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        1,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Jaime Monsalve"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.collector_email))
            .check(ViewAssertions.matches(TestUtils.hasValueEqualTo("jmonsalve@rtvc.com.co")))

        Espresso.onView(ViewMatchers.withId(R.id.collector_telephone))
            .perform(ViewActions.swipeUp())

        Thread.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.albumsOfCollectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    TestUtils.atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Poeta del pueblo"))
                    )
                )
            )
    }

}