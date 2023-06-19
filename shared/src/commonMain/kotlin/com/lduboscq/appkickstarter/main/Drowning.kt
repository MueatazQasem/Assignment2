package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lduboscq.appkickstarter.ui.Image
import org.jetbrains.compose.resources.ExperimentalResourceApi

internal class Drowning : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
        ) {
            Column(Modifier.padding(16.dp)) {
                Row(Modifier.padding(bottom = 16.dp)) {
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Service)) }) {
                        Text("Home")
                    }
                }
                Image(
                    url = "https://st4.depositphotos.com/13264288/19803/v/600/depositphotos_198039718-stock-illustration-drowning-man-sticking-out-of.jpg",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Dealing with Wounds",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Follow these steps to properly deal with wounds:",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 1: Clean your hands thoroughly with soap and water or use hand sanitizer.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 2: Rinse the wound gently with clean water to remove dirt and debris.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 3: Apply an antiseptic solution or ointment to help prevent infection.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 4: Cover the wound with a sterile dressing or bandage to protect it.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 5: Change the dressing regularly and monitor the wound for signs of infection.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }

}
