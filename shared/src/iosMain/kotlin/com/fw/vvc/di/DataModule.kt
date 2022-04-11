package com.fw.vvc.di

import com.fw.vvc.data.repositories.SessionRepositoryImpl
import com.fw.vvc.domain.repositories.SessionRepository

class DataModule {

    private val frameworkModule = FrameworkModule()

    private val sessionRepository: SessionRepository by lazy {
        SessionRepositoryImpl(frameworkModule.provideSessionDao())
    }

    fun provideSessionRepository() = sessionRepository

}