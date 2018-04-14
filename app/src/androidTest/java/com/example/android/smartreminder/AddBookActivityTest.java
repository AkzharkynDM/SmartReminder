package com.example.android.smartreminder;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;


public class AddBookActivityTest {

    @Rule
    public ActivityTestRule<AddBookActivity> addBookActivityActivityTestRule = new ActivityTestRule<AddBookActivity>(AddBookActivity.class);

    private AddBookActivity mActivity = null;
    private DatabaseHandler dbHandler;

    @Before
    public void init() throws Exception {
        mActivity = addBookActivityActivityTestRule.getActivity();
        dbHandler = new DatabaseHandler(AddBook.this);

    }

    @Test
    public void testAddingBook(){
        assertNotNull(mActivity.findViewById(R.id.textview));
        onView(withId(R.id.btnSetDeadline)).perform(click());

        int actualCount=dbHandler.getAllBooks().size();
        int expectedCount=1;
        assertEquals(actualCount, expectedCount);
    }

    @After
    public void tearDown() throws Exception {
        mActivity.finish();
        mActivity = null;
        dbHandler=null;
    }

}