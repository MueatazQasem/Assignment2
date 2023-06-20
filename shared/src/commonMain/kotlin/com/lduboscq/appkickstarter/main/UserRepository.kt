package com.lduboscq.appkickstarter.main

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(userName: String): UserData?
    suspend fun addUser(UserData: UserData): UserData?
    suspend fun updateUser(userName: String, newPassword: String): UserData?
    suspend fun deleteUser(userName: String): UserData?
    suspend fun getAllUsersList(userName: String?): List<UserData>
    suspend fun getAllUsers(userName: String?): MutableState<List<UserData>>
    suspend fun getAllUsersFlow(userName: String?): Flow<List<UserData>>
}