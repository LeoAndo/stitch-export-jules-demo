package com.example.stitch_export_jules_demo

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.stitch_export_jules_demo.ui.navigation.AppNavigation
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testOnboardingToDashboardNavigation() {
        // Onboarding screen should be displayed
        composeTestRule.onNodeWithText("アルプスでスキーを愛する人々のためのモバイルアプリ").assertExists()

        // Click the "Get Started" button
        composeTestRule.onNodeWithText("はじめる").performClick()

        // Dashboard screen should be displayed
        composeTestRule.onNodeWithText("スキーダッシュボード").assertExists()
    }
}
