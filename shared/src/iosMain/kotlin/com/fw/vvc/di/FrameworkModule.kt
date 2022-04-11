package com.fw.vvc.di

import com.fw.vvc.data.DatabaseDriverFactory
import com.fw.vvc.data.cache.SessionDao
import com.fw.vvc.data.cache.SessionDaoImpl
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class FrameworkModule {

    private val httpClient: HttpClient by lazy {
        HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }
    }

    private val databaseDriverFactory: DatabaseDriverFactory by lazy {
        DatabaseDriverFactory()
    }

    private val sessionDao: SessionDao by lazy {
        SessionDaoImpl(databaseDriverFactory)
    }

    fun provideSessionDao() = sessionDao

}