package com.co.retrofit;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.co.retrofit.TestUtils.atPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import com.co.retrofit.app.R;
import com.co.retrofit.app.feature.view.activities.MainActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Test1Artists {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1Artist() {

        ViewInteraction artistastBtn = onView(allOf(withId(R.id.navigation_artist),isDisplayed()));
        artistastBtn.perform(click());

        ViewInteraction artistsList = onView(allOf(withId(R.id.artistRecyclerView)));
        artistsList.check(matches(isDisplayed()));

        onView(withId(R.id.artistRecyclerView))
                .check(matches(atPosition(0, hasDescendant(withText("The Cat Empire")))));

        onView(withId(R.id.navigation_album)).perform(click()).check(matches(isDisplayed()));

        onView(withId(R.id.navigation_artist)).perform(click()).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.artistRecyclerView))).check(matches(isDisplayed()));

        onView(withId(R.id.artistRecyclerView))
                .check(matches(atPosition(1, hasDescendant(withText("Rammstein")))));

        onView(withId(R.id.navigation_collector)).perform(click()).check(matches(isDisplayed()));

        onView(withId(R.id.navigation_artist)).perform(click()).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.artistRecyclerView))).check(matches(isDisplayed()));

        onView(withId(R.id.artistRecyclerView))
                .check(matches(atPosition(3, hasDescendant(withText("Queen")))));
    }
}