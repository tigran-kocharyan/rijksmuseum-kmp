package com.totowka.kmp.util

import com.totowka.kmp.di.getCommonModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getCommonModules())
    }
}