package com.lduboscq.appkickstarter

import io.realm.kotlin.Realm
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.exceptions.SyncException
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.mongodb.sync.SyncSession
import io.realm.kotlin.types.RealmUUID

class FrogRepositorySync() : FrogRepository() {

    private val appServiceInstance by lazy {
        val configuration =
            AppConfiguration.Builder("application-0-gyyqh").log(LogLevel.ALL)
                .build()
        App.create(configuration)
    }

    override suspend fun setupRealmSync() {
        val user =
            appServiceInstance.login(Credentials.apiKey("MsbjtAWlrZtqjethAsaMKqPVVMMAUVwyCpxtdwaqe7AaFI1tsbpMQ46gT2w8NOEG"))

        println("Got Here")
        val config = SyncConfiguration.Builder(user, setOf(Frog::class))
            .initialSubscriptions { realm ->
                add(
                    realm.query<Frog>(
                        Frog::class,
                        "_id == $0",
                        user.id
                    ),
                    name = "FrogSub",
                    updateExisting = true
                )
            }
            .errorHandler { session: SyncSession, error: SyncException ->
                println("*************\n" + error)
            }
            .build()
        realm = Realm.open(config)
    }




}
