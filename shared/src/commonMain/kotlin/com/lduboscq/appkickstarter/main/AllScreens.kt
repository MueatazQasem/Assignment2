package com.lduboscq.appkickstarter.main

sealed class AllScreens {
    object Home : AllScreens()
    object About : AllScreens()
    object Contact : AllScreens()
    object Profile : AllScreens()
    object Service : AllScreens()
    object CPR : AllScreens()
    object Wounds : AllScreens()
    object BrokenBone : AllScreens()
    object Drowning : AllScreens()

    object UserScreen : AllScreens()
}
