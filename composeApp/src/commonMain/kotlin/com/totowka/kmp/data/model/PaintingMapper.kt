package com.totowka.kmp.data.model

import com.totowka.kmp.domain.model.PaintingDomain

class PaintingMapper {

    fun map(paintings: List<PaintingDto>): List<PaintingDomain> {
        return paintings.map { painting -> mapPainting(dto = painting) }
    }

    private fun mapPainting(dto: PaintingDto): PaintingDomain {
        return PaintingDomain(
            id = dto.id,
            title = dto.title,
            artistName = dto.artistName,
            imageUrl = dto.imageUrl,
        )
    }
}