package com.totowka.android.ui

import android.app.Application
import com.totowka.kmp.di.initKoin

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
