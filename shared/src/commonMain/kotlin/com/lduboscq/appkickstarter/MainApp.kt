package com.lduboscq.appkickstarter

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.lduboscq.appkickstarter.list.ListScreenContent
import com.lduboscq.appkickstarter.list.PersonsListScreen
import com.lduboscq.appkickstarter.main.MainScreen
import ui.theme.AppTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
public fun MainApp() {
    AppTheme {
        // Scaffold is a layout structure where I can place a AppBar, FloatingActionButton, and content.
        Scaffold(
            // The top bar of the Scaffold. It's usually used for navigation icons, title, and action items.
            topBar = { TopAppBar(title = { Text("Emergency App") }) },

            // The bottom bar of the Scaffold. It's typically used for navigation, it's similar to the footer in Web application.
            bottomBar = {
                BottomAppBar {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {// Created Box so that i can Center Text position in ButtonBar. Inspired by Developers.com
                        Text("Copyright (c)2023, Inc.")
                    }
                } },

            // The primary area for placing the main content of the Scaffold.
            content = {
                // Calling the Banner() composable which contains my registration form.
            }
        )

        Navigator(MainScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}


