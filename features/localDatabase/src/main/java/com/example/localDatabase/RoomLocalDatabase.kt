package com.example.localDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 2,
    entities = [FirstTableEntity::class]
)
internal abstract class RoomLocalDatabase: RoomDatabase() {

    abstract fun firstTableDAO(): FirstTableDAO
}