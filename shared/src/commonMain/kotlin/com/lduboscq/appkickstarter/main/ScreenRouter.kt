package com.lduboscq.appkickstarter.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

fun screenRouter(screen: AllScreens) : Screen {
    return when (screen) {
        is AllScreens.Home -> MainScreen()
        is AllScreens.About -> AboutScreen()
        is AllScreens.Contact -> ContactScreen()
    }
}
