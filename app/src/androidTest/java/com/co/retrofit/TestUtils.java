package com.co.retrofit;



import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.allOf;
import static kotlin.jvm.internal.Intrinsics.checkNotNull;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by dannyroa on 5/9/15.
 */
public class TestUtils {

    public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(final RecyclerView view) {
                RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    // has no item on such position
                    return false;
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

    public static ViewAction setTextEditText(final Matcher<View> matcher,
                                             final String newText) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(EditText.class));
            }

            @Override
            public String getDescription() {
                return "Update the text from the custom EditText";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                ((EditText) view).setText(newText);
            }
        };
    }

    public static Matcher<View> hasValueEqualTo(final String content) {

        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Has EditText/TextView the value:  " + content);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextView) && !(view instanceof EditText)) {
                    return false;
                }
                if (view != null) {
                    String text;
                    if (view instanceof TextView) {
                        text = ((TextView) view).getText().toString();
                    } else {
                        text = ((EditText) view).getText().toString();
                    }

                    return (text.equalsIgnoreCase(content));
                }
                return false;
            }
        };
    }




}