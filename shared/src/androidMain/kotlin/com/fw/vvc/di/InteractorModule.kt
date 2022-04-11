package com.fw.vvc.di

import android.content.Context
import com.fw.vvc.interactor.session.LoginInteractor

class InteractorModule(context: Context) {

    private val dataModule = DataModule(context)

    private val loginInteractor: LoginInteractor by lazy {
        LoginInteractor(dataModule.provideSessionRepository())
    }

    fun provideLoginInteractor() = loginInteractor

}