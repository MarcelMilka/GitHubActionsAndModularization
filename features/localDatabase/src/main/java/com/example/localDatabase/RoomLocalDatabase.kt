package com.example.localDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [FirstTableEntity::class]
)
abstract class RoomLocalDatabase: RoomDatabase() {

    abstract fun firstTableDAO(): FirstTableDAO
}