package com.atiurin.sampleapp.tests.espresso


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.helper.*
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.pages.UIMainPage.dashboard_menu
import com.atiurin.sampleapp.pages.UIMainPage.openChatWithFriend
import com.atiurin.sampleapp.pages.UIMenuModelPage.customClicks
import com.atiurin.sampleapp.pages.UIMenuModelPage.customPage
import com.atiurin.sampleapp.pages.UIMenuModelPage.menuBar
import com.atiurin.sampleapp.pages.UIMessagePage.isMessageDisplayed
import com.atiurin.sampleapp.pages.UIMessagePage.sendButton
import com.atiurin.sampleapp.pages.UIMessagePage.toolBarTitle
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.ultron.extensions.tap
import io.github.cdimascio.dotenv.Dotenv
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests : BaseTest() {


    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun textWithMyFriend() {
        with(UIElementPage) {
            isTextOnScreen("Friends")
            nameChandler.isViewDisplayed()
            nameChandler.tap()
            textInput.typeText("Hello Rachel")
            messageInputText.isViewDisplayed()
        }
    }

    @Test
    fun firstTest() {
        with(UIElementPage) {

            val friend = InstrumentationRegistry.getArguments().getString("FRIEND_NAME", "Rachel Green")
            val textMessage = InstrumentationRegistry.getArguments().getString("TEXT_MESSAGE", "Hello Rachel")

            dashboard_menu.isViewDisplayed();
            // Check if User is displayed
            openChatWithFriend(friend)
            // Open Chat with User
            openChatWithFriend(friend).tap()
            // Here we check if User is open
            toolBarTitle(friend).isViewDisplayed()
            // We Type Text in Box
            textInput.typeText(textMessage)
            // Check if send button is displayed
            sendButton.isViewDisplayed()
            // We Assert that input box has what we wrote
            assert(isMessageDisplayed(textMessage).isViewDisplayed()) {
                "Message is not displayed in input box"
            }
            // click send button
            sendButton.tap()
            // Now we check if message is displayed  in chat
            assert(checkMessageInRecyclerView(textMessage)) {
                "Message is not in chat"
            }
        }
    }

    @Test
    fun secondTest() {
        with(UIElementPage) {
            // Check dashboard is visible
            dashboard_menu.isViewDisplayed();
            // Open Main Menu (Burger Menu)
            menuBar.isViewDisplayed()
            menuBar.tap()
            // Choose "Custom Clicks" Option and open it
            customClicks.isViewDisplayed()
            customClicks.tap()
            // Check "Custom Clicks" page is open
            customPage.isViewDisplayed()
            // Mark all corner circle
            markCornerCircles()
            // Validate all corner circles are marked
            validateMarkedCornerCircles()
        }
    }
}
