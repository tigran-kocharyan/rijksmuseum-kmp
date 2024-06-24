package com.totowka.kmp.data

import com.totowka.kmp.data.model.PaintingMapper
import com.totowka.kmp.domain.model.PaintingDomain
import com.totowka.kmp.domain.MuseumRepository

class MuseumRepositoryImpl(
    private val museumApi: MuseumApi,
    private val museumStorage: MuseumStorage,
    private val paintingMapper: PaintingMapper,
) : MuseumRepository {

    override suspend fun getPaintings(): List<PaintingDomain> {
        val paintings = museumStorage.getObjects().ifEmpty {
            val newPaintings = museumApi.getPaintings()
            museumStorage.saveObjects(newPaintings)
            newPaintings
        }
        return paintingMapper.map(paintings = paintings)
    }
}
