package com.fw.vvc.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VolunteerVictoriaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}