package com.fw.vvc.di

import com.fw.vvc.interactor.session.LoginInteractor

class InteractorModule {

    private val dataModule = DataModule()

    private val loginInteractor: LoginInteractor by lazy {
        LoginInteractor(dataModule.provideSessionRepository())
    }

    fun provideLoginInteractor() = loginInteractor

}