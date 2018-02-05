package br.concrete.trainingkotlin.feature.home

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import br.concrete.trainingkotlin.R
import org.junit.Rule
import org.junit.Test

/**
 * @author Alison Soldado
 */

@SmallTest
class JHomeActivityTest {

    companion object {
        const val DEFAULT_EMPTY_DESCRIPTION = "-"
        const val DIALOG_TITLE = "Atenção"
        const val TITLE = "título"
        const val DESCRIPTION = "Alguma descrição relevante ao tópico"
        const val EMPTY_STRING = ""
    }

    @Rule
    @JvmField var mActivityRule =
            ActivityTestRule(JHomeActivity::class.java, false, true)

    @Test
    fun givenTitleAndDescription_WhenClickButtonAdd_ThenShowTitleAndDescriptionInList() {
        // Arrange
        mActivityRule.launchActivity(Intent())
        // Act
        onView(withId(R.id.add_item)).perform(click())
        onView(withId(R.id.task)).perform(replaceText(TITLE))
        onView(withId(R.id.description)).perform(replaceText(DESCRIPTION))
        onView(withId(R.id.add_item)).perform(click())
        // Assert
        onView(withText(TITLE)).check(matches(isDisplayed()))
        onView(withText(DESCRIPTION)).check(matches(isDisplayed()))
    }

    @Test
    fun givenTitleEmpty_WhenClickButtonAdd_ThenShowDialogWarning() {
        // Arrange
        mActivityRule.launchActivity(Intent())
        // Act
        onView(withId(R.id.add_item)).perform(click())
        onView(withId(R.id.task)).perform(replaceText(EMPTY_STRING))
        onView(withId(R.id.description)).perform(replaceText(DESCRIPTION))
        onView(withId(R.id.add_item)).perform(click())
        // Assert
        onView(withText(DIALOG_TITLE)).check(matches(isDisplayed()))
    }

    @Test
    fun givenDescriptionEmpty_WhenClickButtonAdd_ThenShowItemInListWithDescriptionDefault() {
        // Arrange
        mActivityRule.launchActivity(Intent())
        // Act
        onView(withId(R.id.add_item)).perform(click())
        onView(withId(R.id.task)).perform(replaceText(TITLE))
        onView(withId(R.id.description)).perform(replaceText(EMPTY_STRING))
        onView(withId(R.id.add_item)).perform(click())
        // Assert
        onView(withText(TITLE)).check(matches(isDisplayed()))
        onView(withText(DEFAULT_EMPTY_DESCRIPTION)).check(matches(isDisplayed()))
    }
}
