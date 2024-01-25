package com.atiurin.sampleapp.pages


import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object UIMenuModelPage {

    // Custom Clicks Option
    val customClicks: Matcher<View> by lazy {
        Matchers.allOf(withId(R.id.custom_clicks_nav_item))
    }

    // Custom page
    val customPage: Matcher<View> by lazy {
        Matchers.allOf(withId(R.id.content))
    }

    fun getMatcherForView(@IdRes viewId: Int): Matcher<View> {
        return Matchers.allOf(withId(viewId), isDisplayed())
    }

    val top_left_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_top_left) }
    val top_center_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_top_center) }
    val top_right_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_top_right) }
    val center_left_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_center_left) }
    val center_right_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_center_right) }
    val bottom_left_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_bottom_left) }
    val bottom_center_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_bottom_center) }
    val bottom_right_checkBox: Matcher<View> by lazy { getMatcherForView(R.id.rB_bottom_right) }


    // Menu Button
    val menuBar: Matcher<View> by lazy {
        Matchers.allOf(withContentDescription("Open navigation drawer"), withParent(withId(R.id.toolbar)))
    }
}