package com.totowka.kmp.data

import com.totowka.kmp.data.datastore.local.AppDatabase
import com.totowka.kmp.data.datastore.local.MuseumDao
import com.totowka.kmp.data.datastore.remote.MuseumApi
import com.totowka.kmp.data.model.PaintingMapper
import com.totowka.kmp.domain.MuseumRepository
import com.totowka.kmp.domain.model.PaintingDomain

class MuseumRepositoryImpl(
    private val museumApi: MuseumApi,
    private val database: AppDatabase,
    private val paintingMapper: PaintingMapper,
) : MuseumRepository {

    private val dao: MuseumDao by lazy {
        database.getDao()
    }

    override suspend fun getPaintings(): List<PaintingDomain> {
        val paintings = dao.getAll().ifEmpty {
            val newPaintings = museumApi.getPaintings().sortedBy { it.id }
            dao.insert(newPaintings)
            newPaintings
        }
        return paintingMapper.map(paintings = paintings)
    }

    override suspend fun refreshPaintings(): List<PaintingDomain> {
        dao.deleteAll()
        val newPaintings = museumApi.getPaintings().sortedBy { it.id }
        dao.insert(newPaintings)
        return paintingMapper.map(paintings = newPaintings)
    }
}
