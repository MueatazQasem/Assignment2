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

internal class BrokenBone : Screen {

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
                    url = "https://st4.depositphotos.com/7843760/20027/v/600/depositphotos_200276094-stock-illustration-boy-showing-broken-arm.jpg",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Dealing with a Broken Bone",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "If someone has a suspected broken bone, follow these steps:",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 1: Stay calm and reassure the person.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 2: Encourage the person to remain still and not move the affected area.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 3: Support the injured area with your hands or use a makeshift splint to immobilize it.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 4: Apply ice packs wrapped in a cloth to reduce swelling.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 5: Seek medical help immediately or call emergency services.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Step 6: Do not try to realign the bone or push any protruding bone back into place.",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}
