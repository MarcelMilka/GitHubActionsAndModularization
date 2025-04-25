package com.example.localDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface FirstTableDAO {

    @Query("SELECT * FROM firsttableentity")
    suspend fun fetchData(): List<FirstTableEntity>?

    @Insert
    suspend fun addData(firstTableEntity: FirstTableEntity)
}