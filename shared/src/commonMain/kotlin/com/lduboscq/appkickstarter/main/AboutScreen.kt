package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.ExperimentalResourceApi

internal class AboutScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
        ) {
            Column {
                // Row for navigation buttons
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Service)) }) {
                        Text("Home")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Contact)) }) {
                        Text("Contact Us")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Profile)) }) {
                        Text("Profile")
                    }
                }

                // Additional content for the About Screen
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "About Emergency App",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Welcome to our Emergency App!",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Our app is designed to provide you with quick access to emergency services and essential information during critical situations.",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Key Features:",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1. Call emergency services with a single tap.",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "2. Learn essential information during emergency situations.",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "3. Access first aid and emergency preparedness information.",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                }
            }
        }
    }

}
