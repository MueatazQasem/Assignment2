import androidx.compose.runtime.MutableState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.lduboscq.appkickstarter.main.UserData
import com.lduboscq.appkickstarter.main.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserScreenModel(private val repository: UserRepository) :
    StateScreenModel<UserScreenModel.State>(State.Init) {
    // Flow to hold the list of user data

    private val _userList = MutableStateFlow<List<UserData>>(emptyList())
    val usersDataState: StateFlow<List<UserData>> = _userList.asStateFlow()

    init {
        // Initialize the user data by collecting it from the repository
        coroutineScope.launch {
            var usersData: Flow<List<UserData>> = repository.getAllUsersFlow(null)
            usersData.collect { users ->
                _userList.value = users
            }
        }
    }

    sealed class State {
        object Init : State()
        object Loading : State()
        sealed class Result : State() {
            class SingleResult(val userData: UserData?) : Result()
            class MultipleResult(val usersData: MutableState<List<UserData>>) : Result()
            class MultipleResultList(val usersData: List<UserData>) : Result()
            class UpdateResult(val updatedUserData: UserData?) : Result()
        }
    }
    // Get user data by username
    fun getUser(userName: String) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result.SingleResult(repository.getUser(userName))
        }
    }
    // Get all users by username
    fun getAllUsers(userName : String?) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result.MultipleResult(repository.getAllUsers(userName))
        }
    }
    // Get all users as a list by username
    fun getAllUsersList(userName : String?) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value =
                State.Result.MultipleResultList(repository.getAllUsersList(userName))
        }
    }
    // Add a new user
    fun addUser(userData: UserData) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result.SingleResult(repository.addUser(userData))
        }
    }
    // Update an existing user
    fun updateUser(userName: String, newPassword: String) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            val updatedUserData = repository.updateUser(userName, newPassword)
            mutableState.value = State.Result.UpdateResult(updatedUserData)
        }
    }
    // Delete a user
    fun deleteUser(userName: String) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result.SingleResult(repository.deleteUser(userName))
        }
    }
}