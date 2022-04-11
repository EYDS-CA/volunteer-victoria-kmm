package com.fw.vvc.android.di

import android.app.Application
import android.content.Context
import com.fw.vvc.data.DatabaseDriverFactory
import com.fw.vvc.di.InteractorModule
import com.fw.vvc.interactor.session.LoginInteractor
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Singleton
    @Provides
    fun provideInteractorModule(application: Application): InteractorModule {
        return InteractorModule(application.applicationContext)
    }

    @Singleton
    @Provides
    fun provideLoginInteractor(interactorModule: InteractorModule): LoginInteractor {
        return interactorModule.provideLoginInteractor()
    }

}