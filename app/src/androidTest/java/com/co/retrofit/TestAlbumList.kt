package com.co.retrofit;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso.onView;
import androidx.test.espresso.action.ViewActions.click;
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import androidx.test.espresso.action.ViewActions.replaceText;
import androidx.test.espresso.action.ViewActions.scrollTo;
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.matcher.ViewMatchers.withText;
import org.hamcrest.Matchers.allOf;
import com.co.retrofit.app.R;
import androidx.test.espresso.Espresso;


import com.co.retrofit.app.feature.view.activities.MainActivity;

@LargeTest
@RunWith(AndroidJUnit4::class)

public class Test1AlbumList {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    //public void test1Album() {
        fun test(){

        onView(allOf(withId(R.id.navigation_artist),isDisplayed())).perform(click())
        }


        /*ViewInteraction loginBtn = onView(allOf(withId(R.id.show_login_button), withText("Login"),isDisplayed()));
        loginBtn.perform(click());

        ViewInteraction usernameTxt = onView(withId(R.id.username));
        usernameTxt.perform(scrollTo(), replaceText("monbi202010@gmail.com"), closeSoftKeyboard());

        ViewInteraction pwdTxt = onView(withId(R.id.password));
        pwdTxt.perform(scrollTo(), replaceText("123456789MISO"), closeSoftKeyboard());

        ViewInteraction confirmLoginBtn = onView(allOf(withId(R.id.login_btn), withText("Login")));
        confirmLoginBtn.perform(scrollTo(), click()); */
    //}
}