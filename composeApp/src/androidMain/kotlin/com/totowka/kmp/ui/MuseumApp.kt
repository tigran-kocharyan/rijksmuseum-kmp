package com.totowka.kmp.ui

import android.app.Application
import com.totowka.kmp.di.MuseumKoin
import org.koin.android.ext.koin.androidContext

class MuseumApp : Application() {
    companion object {
        lateinit var INSTANCE: MuseumApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        MuseumKoin.setupKoin {
            androidContext(this@MuseumApp)
        }
    }
}
