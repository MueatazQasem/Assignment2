package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.ExperimentalResourceApi

internal class ContactScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column {

        }

        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
        ) {
            Column {
            Text("Please contact us")
            Button(onClick = { navigator.push(screenRouter(AllScreens.Home)) }) {
                Text("Home")
            }
            }
        }
    }
}