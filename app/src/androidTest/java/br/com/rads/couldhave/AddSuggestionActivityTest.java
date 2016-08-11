package br.com.rads.couldhave;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.rads.couldhave.addsuggestion.AddSuggestionActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Rafael on 8/9/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddSuggestionActivityTest {

    private static final String SUGGESTION_TITLE = "my suggestion title";

    @Rule
    public ActivityTestRule<AddSuggestionActivity> activityTestRule = new ActivityTestRule<>(AddSuggestionActivity.class);

    @Test
    public void addSuggestion_closeActivity() throws Exception {
        ViewInteraction editTextInteraction = onView(withId(R.id.add_suggestion_title_edit_text));
        editTextInteraction.perform(typeText(SUGGESTION_TITLE), closeSoftKeyboard());
        editTextInteraction.check(matches(withText(SUGGESTION_TITLE)));

        onView(withId(R.id.add_suggestion_button)).perform(click());
        assertTrue(activityTestRule.getActivity().isFinishing());
    }

    @Test
    public void addSuggestion_failCases() throws Exception {

        onView(withId(R.id.add_suggestion_button)).perform(click());
        assertFalse(activityTestRule.getActivity().isFinishing());

        onView(withId(R.id.add_suggestion_title_edit_text)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.add_suggestion_button)).perform(click());
        assertFalse(activityTestRule.getActivity().isFinishing());
    }

    @Test
    public void addSuggestion_successCase() throws Exception {
        onView(withId(R.id.add_suggestion_title_edit_text)).perform(typeText(SUGGESTION_TITLE), closeSoftKeyboard());
        onView(withId(R.id.add_suggestion_button)).perform(click());
        assertTrue(activityTestRule.getActivity().isFinishing());

    }
}
