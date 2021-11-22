package com.co.retrofit

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
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
import androidx.test.espresso.action.ViewActions.typeText

import androidx.test.espresso.action.ViewActions.clearText

import androidx.test.espresso.matcher.ViewMatchers.withClassName

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers.allOf


@RunWith(AndroidJUnit4::class)
@LargeTest
class AlbumCreationEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClickInCreateAlbum() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheCover() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheName() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
    }
}
