package com.lduboscq.appkickstarter.main



import UserScreen
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

fun screenRouter(screen: AllScreens) : Screen {
    return when (screen) {
        is AllScreens.Home -> MainScreen()
        is AllScreens.About -> AboutScreen()
        is AllScreens.Contact -> ContactScreen()
        is AllScreens.Profile -> ProfileScreen()
        is AllScreens.Service -> ServiceScreen()
        is AllScreens.CPR -> CPR()
        is AllScreens.Wounds -> Wounds()
        is AllScreens.Drowning -> Drowning()
        is AllScreens.BrokenBone -> BrokenBone()
        is AllScreens.UserScreen -> UserScreen()
    }
}
