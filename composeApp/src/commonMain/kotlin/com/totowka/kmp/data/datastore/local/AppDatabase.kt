package com.totowka.kmp.data.datastore.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.totowka.kmp.data.model.PaintingEntity
import org.koin.core.module.Module

@Database(entities = [PaintingEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(), ClearAllTablesWorkaround {
    abstract fun getDao(): MuseumDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// https://issuetracker.google.com/issues/342905180
// пока поддержка kotlin 2.0 в разработке, воспользуемся workaround для сборки
interface ClearAllTablesWorkaround {
    fun clearAllTables(): Unit {}
}

expect fun roomModule(): Module