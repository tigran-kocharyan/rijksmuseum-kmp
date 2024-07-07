package com.totowka.kmp.domain

import com.totowka.kmp.domain.model.PaintingDomain

class MuseumInteractor(
    private val museumRepository: MuseumRepository,
) {

    suspend fun getPaintings(): List<PaintingDomain> {
        return museumRepository.getPaintings()
    }

    suspend fun refreshPaintings(): List<PaintingDomain> {
        return museumRepository.refreshPaintings()
    }
}