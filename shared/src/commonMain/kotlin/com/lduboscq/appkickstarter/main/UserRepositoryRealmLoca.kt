package com.lduboscq.appkickstarter.data

import com.lduboscq.appkickstarter.main.User
import com.lduboscq.appkickstarter.main.UserRepositoryRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class UserRepositoryRealmLocal : UserRepositoryRealm() {
    override suspend fun setupRealmSync() {
        // Create a RealmConfiguration with User class as the schema
        val config = RealmConfiguration.Builder(setOf(User::class))
            .build()
        // Open a Realm instance with the configuration
        realm = Realm.open(config)
    }
}