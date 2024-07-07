package com.totowka.kmp.data.datastore.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.totowka.kmp.data.model.PaintingEntity

@Dao
interface MuseumDao {
    @Insert
    suspend fun insert(items: List<PaintingEntity>)

    @Query("DELETE FROM PaintingEntity")
    suspend fun deleteAll()

    @Query("SELECT * FROM PaintingEntity")
    suspend fun getAll(): List<PaintingEntity>
}