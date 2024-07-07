package com.totowka.kmp.data.model

import com.totowka.kmp.domain.model.PaintingDomain

class PaintingMapper {

    fun map(paintings: List<PaintingEntity>): List<PaintingDomain> {
        return paintings.map { painting -> mapPainting(dto = painting) }
    }

    private fun mapPainting(dto: PaintingEntity): PaintingDomain {
        return PaintingDomain(
            id = dto.id,
            title = dto.title,
            artistName = dto.artistName,
            imageUrl = dto.imageUrl,
        )
    }
}