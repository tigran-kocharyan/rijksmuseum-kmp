package com.totowka.kmp.di

import com.totowka.kmp.data.InMemoryMuseumStorage
import com.totowka.kmp.data.KtorMuseumApi
import com.totowka.kmp.data.MuseumApi
import com.totowka.kmp.data.MuseumRepositoryImpl
import com.totowka.kmp.data.MuseumStorage
import com.totowka.kmp.data.model.PaintingMapper
import com.totowka.kmp.domain.MuseumInteractor
import com.totowka.kmp.domain.MuseumRepository
import com.totowka.kmp.ui.screens.list.ListScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private fun dataModule() = module {
    factory<PaintingMapper> {
        PaintingMapper()
    }

    factory<MuseumRepository> {
        MuseumRepositoryImpl(
            museumApi = get(),
            museumStorage = get(),
            paintingMapper = get(),
        )
    }

    single<MuseumApi> { KtorMuseumApi(get()) }

    single<MuseumStorage> { InMemoryMuseumStorage() }

    single {
        val json = Json {
            ignoreUnknownKeys = true
            useAlternativeNames = false
        }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }
}

private fun domainModule() = module {
    factory<MuseumInteractor> {
        MuseumInteractor(
            museumRepository = get(),
        )
    }
}

private fun screensModule() = module {
    factoryOf(::ListScreenModel)
}

private fun commonModules() = listOf(
    domainModule(),
    dataModule(),
    screensModule(),
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
