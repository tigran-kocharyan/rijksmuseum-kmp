package com.totowka.kmp.data

import com.totowka.kmp.data.model.PaintingDto

interface MuseumStorage {
    suspend fun saveObjects(newPaintings: List<PaintingDto>)

    fun getObjects(): List<PaintingDto>
}

class InMemoryMuseumStorage : MuseumStorage {
    private var storedPaintings = emptyList<PaintingDto>()

    override suspend fun saveObjects(newPaintings: List<PaintingDto>) {
        storedPaintings = newPaintings
    }

    override fun getObjects(): List<PaintingDto> = storedPaintings
}