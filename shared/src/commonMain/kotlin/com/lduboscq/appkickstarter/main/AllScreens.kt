package com.lduboscq.appkickstarter.main

sealed class AllScreens {
    object Home : AllScreens()
    object About : AllScreens()
    object Contact : AllScreens()
}