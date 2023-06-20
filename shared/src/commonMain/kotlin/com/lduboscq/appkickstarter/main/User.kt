package com.lduboscq.appkickstarter.main

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.annotations.PrimaryKey

class User: RealmObject {
    @PrimaryKey
    var _id: String = RealmUUID.random().toString() // Primary key for the user object
    var userName: String ="" // User's username
    var email: String ="" // User's email
    var password: String = "" // User's password
}

data class UserData(
    var id: String? = null, // ID of the user data
    var userName: String ="", // User's username
    var email: String ="", // User's email
    var password: String = "", // User's password
    var user: User? = null // Reference to the associated User object
)
