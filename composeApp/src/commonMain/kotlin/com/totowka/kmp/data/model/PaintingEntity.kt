package com.totowka.kmp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class PaintingEntity(
    @PrimaryKey
    @SerialName("objectID")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("artistDisplayName")
    val artistName: String,
    @SerialName("primaryImageSmall")
    val imageUrl: String,
)
