package com.totowka.kmp.ui

import android.app.Application
import com.totowka.kmp.di.initKoin

class MuseumApp : Application() {
    companion object {
        lateinit var INSTANCE: MuseumApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initKoin()
    }
}
