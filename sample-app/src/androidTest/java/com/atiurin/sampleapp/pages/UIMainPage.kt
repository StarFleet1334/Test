package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf


object UIMainPage {

    val dashboard_menu: Matcher<View> by lazy {
        allOf(allOf(withId(R.id.recycler_friends)));
    }

    fun openChatWithFriend(text: String): Matcher<View> {
        return allOf(withId(R.id.tv_name), withText(text))
    }


}