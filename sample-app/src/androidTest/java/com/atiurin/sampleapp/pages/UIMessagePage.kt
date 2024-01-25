package com.atiurin.sampleapp.pages
import android.util.Log
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.PerformException
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object UIMessagePage {

    // Message in Text Input
    fun isMessageDisplayed(sentMessage: String): Matcher<View> {
        return Matchers.allOf(withId(R.id.message_input_text), withText(sentMessage))
    }

    // Send Button
    val sendButton: Matcher<View> by lazy {
        Matchers.allOf((withId(R.id.send_button)))
    }


    // Message in chat
    fun checkMessageInRecyclerView(message: String): Boolean {
        return try {
            onView(withId(R.id.messages_list))
                .perform(
                    RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                        hasDescendant(withText(message))
                    )
                )
                .check(matches(hasDescendant(withText(message))))
            true // If the actions and checks are passed, return true.
        } catch (e: NoMatchingViewException) {
            false // The view was not found in the current view hierarchy.
        } catch (e: PerformException) {
            false // The scrollTo action couldn't be performed.
        } catch (e: AssertionError) {
            false // The check didn't pass.
        }
    }
}