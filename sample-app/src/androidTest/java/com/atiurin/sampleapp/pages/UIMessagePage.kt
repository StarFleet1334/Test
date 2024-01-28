package com.atiurin.sampleapp.pages
import android.view.View
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

    fun toolBarTitle(person: String): Matcher<View> {
        return Matchers.allOf(withId(R.id.toolbar_title), withText(person))
    }

}