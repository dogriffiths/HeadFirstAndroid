package com.hfad.myfirstapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * This is an Espresso test.
 * <p/>
 * An Espresso test is an example of an *instrumented* test. Instrumented tests run on your Android
 * phone, alongside your app. They are used to test that your code works on a real app.
 * <p/>
 * This test does something very simple: it checks that the app displays some text on the main
 * screen. But some tests can be really quite complex.
 * <p/>
 * You can use Espresso to test pretty much anything that a user might do to your app.
 * <p/>
 * To run this test, right-click the Java folder in Android Studio that is labeled "(androidTest)",
 * or run it from the command-line, by opening a prompt, changing into the project directory and
 * typing:
 * <p/>
 * ./gradlew connectCheck
 * <p/>
 * Created by davidg on 01/09/16.
 */
public class StartupTest {

    /**
     * The rule will make sure the main activity is running.
     */
    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule(MainActivity.class);

    /**
     * This is a test which makes sure that the screen displays a text-view containing the text
     * "Sup doge". It uses a bunch of code from the Espresso test framework:
     *
     * onView(...): This looks for views on the current screen. It's passed a thing called a
     * matcher, which is used to choose which views you're interested in.
     *
     * allOf(...): This is a matcher which checks that a lot of *other* matchers are satisfied.
     *
     * isAssignableFrom(TextView.class): This means we want a TextView, or a sub-class of a
     * TextView....
     *
     * withText("Sup doge"): ...and we also need the view with text "Sup doge"
     *
     * Once we've found the view using the matchers, we then need to call check(...) to test the
     * view. And that how we check it's displayed with check(matches(isDisplayed())).
     */
    @Test
    public void displaysSupDoge() {
        onView(allOf(isAssignableFrom(TextView.class), withText("Sup doge")))
                .check(matches(isDisplayed()));
    }
}
