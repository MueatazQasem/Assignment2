package com.lduboscq.appkickstarter.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import io.realm.kotlin.Realm
import io.realm.kotlin.notifications.ResultsChange
import io.realm.kotlin.types.RealmUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

abstract class UserRepositoryRealm : UserRepository {
    lateinit var realm: Realm
    private var currentJob: Job? = null

    abstract suspend fun setupRealmSync()

    private fun cancelCurrentJob() {
        currentJob?.cancel()
        currentJob = null
    }
    private fun closeRealmSync() {
        realm.close()
    }
    // Converts a User object from Realm into a UserData object
    suspend fun convertToUserData(user: User?): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        var userData: UserData? = null
        realm.write {
            if (user != null) {
                userData = UserData(
                    id = findLatest(user)!!._id,
                    userName = findLatest(user)!!.userName,
                    email = findLatest(user)!!.email,
                    password = findLatest(user)!!.password,
                    user = user
                )
            }
        }
        return userData
    }
    override suspend fun addUser(userData: UserData): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        var user: User? = null
        realm.write {
            user = this.copyToRealm(User().apply {
                _id = userData.id ?: RealmUUID.random().toString()
                userName = userData.userName
                email = userData.email
                password = userData.password

            })
        }
        return convertToUserData(user)
    }
    override suspend fun getUser(userName: String): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        cancelCurrentJob()
        val user: User? =
            realm.query<User>(User::class, "userName = \"$userName\"").first().find()
        return convertToUserData(user)
    }
    override suspend fun getAllUsersList(userName: String?): List<UserData>
    {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        cancelCurrentJob()
        val user: List<User> =

            realm.query<User>(User::class).find()


        val userDataList = user.map { user ->
            UserData(
                id = user._id,
                userName = user.userName,
                email = user.email,
                password = user.password,
                user = user
            )
        }
        return userDataList
    }
    override suspend fun getAllUsers(userName: String?): MutableState<List<UserData>> {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        val userState: MutableState<List<UserData>> = mutableStateOf(emptyList())
        cancelCurrentJob()
        currentJob = CoroutineScope(Dispatchers.Default).launch {
            // Listen to the Realm query result as a Flow
            val userFlow: Flow<ResultsChange<User>> =
                if (userName == null)
                    realm.query<User>(User::class).find().asFlow()
                else
                    realm.query<User>(User::class, "username = \"$userName\"").find()
                        .asFlow()

            userFlow.collect { resultsChange: ResultsChange<User> ->

                val user = resultsChange.list
                val userDataFlow = user.map { user ->
                    UserData(
                        id = user._id,
                        userName = user.userName,
                        email = user.email,
                        password = user.password,
                        user = user
                    )
                }

                // Update the mutable state with the new result
                userState.value = userDataFlow
            }
        }

        return userState
    }
    override suspend fun getAllUsersFlow(userNmae: String?): Flow<List<UserData>> {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        var usersState: Flow<List<UserData>> = flowOf(emptyList())
        cancelCurrentJob()

        currentJob = CoroutineScope(Dispatchers.Default).launch {
            // Listen to the Realm query result as a Flow
            val userFlow: Flow<ResultsChange<User>> =
//
                realm.query<User>(User::class).find().asFlow()


            userFlow.collect { resultsChange: ResultsChange<User> ->
                val users = resultsChange.list
                val userDataFlow = users.map { user ->
                    UserData(
                        id = user._id,
                        userName = user.userName,
                        email = user.email,
                        password = user.password,

                        user = user
                    )
                }

                // Update the mutable state with the new result
                usersState = flowOf(userDataFlow)
            }
        }

        return usersState
    }

    override suspend fun updateUser(userName: String, newPassword: String): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        var UserData: UserData? = null
        try {
            val user: User? =
                realm.query<User>(User::class, "userName = \"$userName\"").first().find()

            realm.write {
                if (user != null) {
                    findLatest(user)!!.password = newPassword
                }
            }
            UserData = convertToUserData(user)
        } catch (e: Exception) {
            println(e.message)
        }

        return UserData
    }

    override suspend fun deleteUser(userName: String): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        var userData: UserData? = null
        try {
            // Search for first match on the name field
            val user: User? =
                realm.query<User>(User::class, "userName = \"$userName\"").first().find()
            realm.write {
                if (user != null) {

                    userData = UserData(
                        id = findLatest(user)!!._id,
                        userName = findLatest(user)!!.userName,
                        email = findLatest(user)!!.email,
                        password = findLatest(user)!!.password,
                        user = null
                    )
                    findLatest(user)
                        ?.also { delete(it) }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }

        return userData
    }
}