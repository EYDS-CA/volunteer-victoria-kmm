package com.fw.vvc.di

import android.content.Context
import com.fw.vvc.data.DatabaseDriverFactory
import com.fw.vvc.data.cache.SessionDao
import com.fw.vvc.data.cache.SessionDaoImpl
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class FrameworkModule(context: Context) {

    private val httpClient: HttpClient by lazy {
        HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }
    }

    private val databaseDriverFactory: DatabaseDriverFactory by lazy {
        DatabaseDriverFactory(context)
    }

    private val sessionDao: SessionDao by lazy {
        SessionDaoImpl(databaseDriverFactory)
    }

    fun provideSessionDao() = sessionDao

}