package com.totowka.kmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaintingDto(
    @SerialName("objectID")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("artistDisplayName")
    val artistName: String,
    @SerialName("primaryImageSmall")
    val imageUrl: String,
)
