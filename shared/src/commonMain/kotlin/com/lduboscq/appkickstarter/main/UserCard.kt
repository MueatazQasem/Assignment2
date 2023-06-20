import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lduboscq.appkickstarter.main.UserData

@Composable
fun UserCard(userData: UserData?) {
    Card(
        modifier = Modifier.size(width = 180.dp, height = 100.dp) // Set the size of the card
    ) {
        if (userData != null) { // Check if user data is available
            Column {
                Text("Name : " + userData?.userName) // Display the user's username
                Text("Email : " + userData?.email) // Display the user's email
                Text("Password : " + userData?.password) // Display the user's password
            }
        } else {
            Text("No user result") // Display a message when no user data is available
        }
    }
}
