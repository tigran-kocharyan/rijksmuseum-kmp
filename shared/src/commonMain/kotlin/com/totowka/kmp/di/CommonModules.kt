package com.totowka.kmp.di

import com.totowka.kmp.domain.CommonInteractor
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private fun domainModule() = module {
    factory<CommonInteractor> {
        CommonInteractor()
    }
}
private fun commonModules() = listOf(
    domainModule(),
)

fun getCommonModules(): List<Module> {
    return commonModules()
}

fun initKoin() {
    startKoin {
        modules(
            commonModules()
        )
    }
}
