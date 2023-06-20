import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.lduboscq.appkickstarter.data.UserRepositoryRealmLocal
import com.lduboscq.appkickstarter.main.Banner
import com.lduboscq.appkickstarter.main.MyBottomBar
import com.lduboscq.appkickstarter.main.MyTopBar
import com.lduboscq.appkickstarter.main.UserCardList
import com.lduboscq.appkickstarter.main.UserData

class UserScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        // Create an instance of UserScreenModel using UserRepositoryRealmLocal
        val screenModel = rememberScreenModel { UserScreenModel(UserRepositoryRealmLocal()) }
        // Collect the state of the screen model as a Compose state
        val state by screenModel.state.collectAsState()
        // Create mutable state variables for username, email, and password
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Scaffold(
            topBar = { MyTopBar() },
            bottomBar = { MyBottomBar() },
            floatingActionButton = {
//                FloatingActionButton(onClick = {}) {
//                    Text("Click Me")
//                }
                // Define a FloatingActionButton

            }
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
//                Banner()

                Text(text="Please enter the username to add/get/update/delete")
                TextField(value = userName, onValueChange = { userName = it })

                Text("Please enter the password to add/get/update/delete")
                TextField(value = password, onValueChange = { password = it })

                Text("Please enter the email to add/get/update/delete")
                TextField(value = email, onValueChange = { email = it })

                if (!userName.isNullOrEmpty()) {
                    // Add/Get/Update/Delete User buttons
                    Row {
                        Button(onClick = {
                            screenModel.addUser(
                                UserData(
                                    userName = userName,
                                    email = email,
                                    password = password,
                                    user = null
                                )
                            )
                        }, Modifier.weight(1f).padding(10.dp)) {
                            Text("Add User")
                        }
                        Button(onClick = { screenModel.getUser(userName) }, Modifier.weight(1f).padding(10.dp)) {
                            Text("Get User")
                        }
                    }
                    Row {
                        Button(onClick = { screenModel.updateUser(userName, password) },Modifier.weight(1f).padding(10.dp)) {
                            Text("Update User")
                        }
                        Button(onClick = { screenModel.deleteUser(userName) },Modifier.weight(1f).padding(10.dp)) {
                            Text("Delete User")
                        }
                    }
                    // Get All Users button

                    Row{
                        Button(onClick = {
                            if (userName.isNullOrEmpty()) screenModel.getAllUsersList(null)
                            else screenModel.getAllUsersList(userName)
                        },Modifier.weight(1f))

                        {
                            Text("Get All users List")
                        }
                    }
                    // Display different UI based on the state
                    if (state is UserScreenModel.State.Result.SingleResult) {
                            val userData =
                                (state as UserScreenModel.State.Result.SingleResult).userData
                            if (userData == null) {
                                Text("The User does not exist.")
                            } else {
                                Text("The results of the action are:")
                               UserCard(userData = userData)
                            }
                        } else if (state is UserScreenModel.State.Result.MultipleResult) {
                            if ((state as UserScreenModel.State.Result.MultipleResult).usersData == null) {
                                Text("Not found.  Please try again.")
                            } else {
                                Text("The results of the action are:")
                                // Access the fetched frogs from the state
                                val usersData =
                                    (state as UserScreenModel.State.Result.MultipleResult).usersData
                                UserCardList(usersData.value)
                            }
                        } else if (state is UserScreenModel.State.Result.MultipleResultList) {
                            if ((state as UserScreenModel.State.Result.MultipleResultList).usersData == null) {
                                Text("Not found.  Please try again.")
                            } else {
                                Text("The results of the action are:")
                                // Access the fetched frogs from the state
                                val usersData =
                                    (state as UserScreenModel.State.Result.MultipleResultList).usersData

                                UserCardList(usersData)
                            }
                        }

                        if (state is UserScreenModel.State.Result.UpdateResult) {
                            val updatedUserData =
                                (state as UserScreenModel.State.Result.UpdateResult).updatedUserData
                            if (updatedUserData == null) {
                                Text("Update failed. Please try again.")
                            } else {
                                Text("User successfully updated:")
                                UserCard(userData = updatedUserData)
                            }
                        }
                    }
                }
            }
        }
    }