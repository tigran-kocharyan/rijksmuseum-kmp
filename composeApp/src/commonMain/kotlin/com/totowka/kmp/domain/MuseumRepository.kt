package com.totowka.kmp.domain

import com.totowka.kmp.domain.model.PaintingDomain

interface MuseumRepository {

    suspend fun getPaintings(): List<PaintingDomain>

    suspend fun refreshPaintings(): List<PaintingDomain>
}