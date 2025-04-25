package com.example.localDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class FirstTableEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val intValue: Int,
    val stringValue: String
)