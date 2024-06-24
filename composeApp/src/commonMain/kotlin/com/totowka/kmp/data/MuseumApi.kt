package com.totowka.kmp.data

import com.totowka.kmp.data.model.PaintingDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.CancellationException

interface MuseumApi {
    suspend fun getPaintings(): List<PaintingDto>
}

class KtorMuseumApi(private val client: HttpClient) : MuseumApi {
    companion object {
        private const val MUSEUM_API_URL = "https://www.rijksmuseum.nl/api/nl/collection?key=OERTdfeD"
        private const val API_URL = "https://raw.githubusercontent.com/Kotlin/KMP-App-Template/main/list.json"
    }

    override suspend fun getPaintings(): List<PaintingDto> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
    }
}
