package com.lduboscq.appkickstarter.main

import UserCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserCardList(userDatas : List<UserData>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        // Create a vertical scrolling column

        for (userData in userDatas) {
            // Iterate through the list of user data

            UserCard(userData)
            // Display a UserCard for each UserData object
        }
    }
}
