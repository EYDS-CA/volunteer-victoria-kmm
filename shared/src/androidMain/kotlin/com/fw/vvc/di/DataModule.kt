package com.fw.vvc.di

import android.content.Context
import com.fw.vvc.data.repositories.SessionRepositoryImpl
import com.fw.vvc.domain.repositories.SessionRepository

class DataModule(context: Context) {

    private val frameworkModule = FrameworkModule(context)

    private val sessionRepository: SessionRepository by lazy {
        SessionRepositoryImpl(frameworkModule.provideSessionDao())
    }

    fun provideSessionRepository() = sessionRepository

}