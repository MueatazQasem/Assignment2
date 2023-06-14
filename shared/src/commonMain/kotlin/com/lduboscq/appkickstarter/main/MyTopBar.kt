package com.lduboscq.appkickstarter.main

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MyTopBar() {
    TopAppBar(title = { Text("My App") })
}