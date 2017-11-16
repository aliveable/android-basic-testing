package cc.somkiat.basicunittesting;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainactTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void revertTest() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void saveCorrectlyTest() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("ALIVEABLE"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("test@testmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveEmptyName() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("test@testmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText(App.getContext().getString(R.string.EmptyName))).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }


    @Test
    public void saveEmptyEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("aliveable"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText(App.getContext().getString(R.string.EmailEmpty))).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void saveWrongName() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("ประยุทธิ์  จันโอชุ (9 sdfo)9"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("test@testmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText(App.getContext().getString(R.string.NameOnlyEnglish))).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void saveWrongEmail() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Aliveable"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("testtestmailcom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withText(App.getContext().getString(R.string.EmailIsWrong))).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

}
