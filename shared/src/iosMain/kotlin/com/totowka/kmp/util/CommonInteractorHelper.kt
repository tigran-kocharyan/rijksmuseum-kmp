package com.totowka.kmp.util

import com.totowka.kmp.domain.CommonInteractor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CommonInteractorHelper : KoinComponent {
    private val interactor: CommonInteractor by inject()
    fun getMessage(): String = interactor.getMessage().message
}