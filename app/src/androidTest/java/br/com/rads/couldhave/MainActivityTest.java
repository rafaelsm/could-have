package br.com.rads.couldhave;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.rads.couldhave.addsuggestion.AddSuggestionActivity;
import br.com.rads.couldhave.constants.Extra;
import br.com.rads.couldhave.domain.model.Suggestion;
import br.com.rads.couldhave.main.MainActivity;

import static android.app.Activity.RESULT_OK;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.init;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Rafael on 8/9/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private static final Suggestion SUGGESTION = new Suggestion("mocked suggestion");

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        init();

        Intent resultData = new Intent();
        resultData.putExtra(Extra.ADD_SUGGESTION, SUGGESTION);
        Instrumentation.ActivityResult activityResult = new Instrumentation.ActivityResult(RESULT_OK,resultData);
        intending(IntentMatchers.hasComponent(AddSuggestionActivity.class.getName())).respondWith(activityResult);
    }

    @Test
    public void tapAddSuggestion_openAddSuggestion() throws Exception {
        onView(withId(R.id.add_suggestion_fab)).check(matches(isDisplayed()));
        onView(withId(R.id.add_suggestion_fab)).perform(click());

        final Activity[] activities = new Activity[1];
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                activities[0] = Iterables.getOnlyElement(ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED));
            }
        });

        assertTrue(activities[0] instanceof AddSuggestionActivity);
    }

    @Test
    public void listSuggestions() throws Exception {
        //TODO: Create use case first
    }

    @Test
    public void addNewSuggestion_updateList() throws Exception {
        onView(withId(R.id.add_suggestion_fab)).perform(click());
        onView(withId(R.id.recycler_view)).check(matches(atPosition(0, hasDescendant(withText(SUGGESTION.getName())))));
    }

    private Matcher<? super View> atPosition(final int position, final Matcher<View> viewMatcher) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                viewMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {
                RecyclerView.ViewHolder viewHolder = item.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    return false;
                }
                return viewMatcher.matches(viewHolder.itemView);
            }
        };
    }
}
