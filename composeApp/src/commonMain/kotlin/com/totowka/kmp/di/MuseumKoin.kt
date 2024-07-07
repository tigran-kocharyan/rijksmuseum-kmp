package com.totowka.kmp.di

import org.koin.core.Koin
import org.koin.dsl.KoinAppDeclaration

object MuseumKoin {
    private var di: Koin? = null

    fun setupKoin(appDeclaration: KoinAppDeclaration = {}) {
        if (di == null) {
            di = initKoin(appDeclaration).koin
        }
    }
}
