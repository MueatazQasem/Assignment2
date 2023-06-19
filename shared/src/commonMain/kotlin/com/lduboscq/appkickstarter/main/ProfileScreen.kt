package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lduboscq.appkickstarter.ui.Image
import org.jetbrains.compose.resources.ExperimentalResourceApi

internal class ProfileScreen : Screen {

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
                Row {

                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Service)) }) {
                        Text("Home")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { navigator.push(screenRouter(AllScreens.Home)) }) {
                        Text("Log Out")

                    }
                }
                Column {

                    // Opting into using ExperimentalResourceApi for loading an image resource
                    @OptIn(ExperimentalResourceApi::class)
                    // Displaying an image, which is aligned to center and has a padding of 5.dp
                    (Image(
        url = ("https://icon-library.com/images/user-icon-jpg/user-icon-jpg-12.jpg"),

        modifier = Modifier.align(Alignment.CenterHorizontally).padding(0.dp, 10.dp)
    ))

                    // Displaying a text for the registration form title, aligned to the center
                    Text(
                        "My Profile!",
                        style = MaterialTheme.typography.h4, modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Spacer is used to provide space between elements, here providing a vertical space of 5.dp
                    Spacer(modifier = Modifier.height(5.dp))


                    // Defining mutable states for the input fields and the display message
                    var InputName by remember { mutableStateOf("") }
                    var InputEmail by remember { mutableStateOf("") }
                    var InputPassword by remember { mutableStateOf("") }
                    var DispalyMessage by remember { mutableStateOf("") }

                    // A TextField for name input, the entered text will be stored in InputName
                    TextField(
                        value = InputName,
                        onValueChange = { InputName = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .align(Alignment.CenterHorizontally)
                    )

                    // A spacer to add space between the text fields
                    Spacer(modifier = Modifier.height(5.dp))

                    // A TextField for email input, the entered text will be stored in InputEmail
                    TextField(
                        value = InputEmail,
                        onValueChange = { InputEmail = it },
                        modifier = Modifier.fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )

                    // Another spacer for visual separation
                    Spacer(modifier = Modifier.height(5.dp))

                    // A TextField for password input, the entered text will be stored in InputPassword
                    TextField(
                        value = InputPassword,
                        onValueChange = { InputPassword = it },
                        modifier = Modifier.fillMaxWidth()
                            .align(Alignment.CenterHorizontally).clip(MaterialTheme.shapes.medium)
                    )

                    // A spacer to add space between the text fields and the display message
                    Spacer(modifier = Modifier.height(10.dp))

                    // A Text composable to display a message, which is aligned to center
                    Text(DispalyMessage, style = TextStyle(fontSize = 20.sp), modifier = Modifier.align(
                        Alignment.CenterHorizontally))

                    // A spacer to add space between the display message and the button
                    Spacer(modifier = Modifier.height(20.dp).width(20.dp).padding(16.dp))

                    Row {Button(
                        onClick = {
                        },
                        modifier = Modifier.size(130.dp,40.dp)
                            .clip(RoundedCornerShape(30)).padding(10.dp, 0.dp)

                    ) {
                        // Text inside the button
                        Text("Update")
                    }
                        Button(
                            onClick = {
                            },
                            modifier = Modifier.size(130.dp,40.dp)
                                .clip(RoundedCornerShape(30)).padding(10.dp, 0.dp)

                        ) {
                            // Text inside the button
                            Text("Find")
                        }
                        Button(
                            onClick = {
                            },
                            modifier = Modifier.size(130.dp,40.dp)
                                .clip(RoundedCornerShape(30)).padding(10.dp, 0.dp)

                        ) {
                            // Text inside the button
                            Text("Delete")
                        }  }


                }
            }
        }
    }
}