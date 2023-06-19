package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
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

internal class ServiceScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
        ) {
            Column {

                // Row for buttons: Contact Us, About, Profile
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick={navigator.push(screenRouter(AllScreens.Contact))}) {
                        Text("Contact Us")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick={navigator.push(screenRouter(AllScreens.About))}) {
                        Text("About")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick={navigator.push(screenRouter(AllScreens.Profile))}) {
                        Text("Profile")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Row for images: CPR, Wounds
                Row(Modifier.fillMaxWidth()) {
                    Image(
                        url = "https://st4.depositphotos.com/24223224/41128/v/600/depositphotos_411281178-stock-illustration-male-character-making-heart-massage.jpg",
                        modifier = Modifier.weight(1f).clickable { navigator.push(screenRouter(AllScreens.CPR)) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        url = "https://st3.depositphotos.com/3440865/15506/v/600/depositphotos_155067600-stock-illustration-crying-girl-with-wounds-from.jpg",
                        modifier = Modifier.weight(1f).clickable { navigator.push(screenRouter(AllScreens.Wounds)) }
                    )
                }

                // Row for images: Drowning, BrokenBone
                Row(Modifier.fillMaxWidth()) {
                    Image(
                        url = "https://st4.depositphotos.com/13264288/19803/v/600/depositphotos_198039718-stock-illustration-drowning-man-sticking-out-of.jpg",
                        modifier = Modifier.weight(1f).clickable { navigator.push(screenRouter(AllScreens.Drowning)) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        url = "https://st4.depositphotos.com/7843760/20027/v/600/depositphotos_200276094-stock-illustration-boy-showing-broken-arm.jpg",
                        modifier = Modifier.weight(1f).clickable { navigator.push(screenRouter(AllScreens.BrokenBone))}
                    )
                }
            }
        }
    }

}