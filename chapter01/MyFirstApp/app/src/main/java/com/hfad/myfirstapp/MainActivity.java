package com.hfad.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This is the code that controls the screen when the app launches.
 *
 * A screen in Android is controlled by an Activity. This is an activity.
 *
 * When the app is launched, Android will create an instance of this class and it will then call
 * the onCreate(...) method to set up the screen.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This is the method that Android calls when the main screen needs to be displayed.
     * @param savedInstanceState -- We'll cover what this does later in the book.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // It's important that your onCreate method calls the super-method before it does
        // anything else
        super.onCreate(savedInstanceState);

        // Now we need to tell Android what the screen will look like. We do this with a "layout".
        // A layout is an XML file which says what widgets will appear on the screen: things
        // like text fields, and buttons, and rectangles full of flying aliens.
        // To see what this layout looks, you should do take a look at the layout XML file in
        // the res/layout/activity_main.xml file.
        setContentView(R.layout.activity_main);
    }
}
