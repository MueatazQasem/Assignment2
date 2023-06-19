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

internal class ContactScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
        ) {
            Column {
                // Row for Home button
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Service)) }) {
                        Text("Home")
                    }
                }

                // Heading: Contact Us
                Text(
                    text = "Contact Us",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(16.dp)
                )

                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    // Text: Description
                    Text(
                        text = "If you have any questions, suggestions, or need assistance, please feel free to reach out to us.",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Contact information
                    Text(
                        text = "Email: contact@example.com",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Phone: +1 123-456-7890",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Follow us on Twitter: @yourapphandle",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )


                    Spacer(modifier = Modifier.height(16.dp))


                }
            }
        }
    }

}

