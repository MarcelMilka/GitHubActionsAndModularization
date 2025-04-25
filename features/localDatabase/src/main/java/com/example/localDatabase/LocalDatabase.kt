package com.example.localDatabase

import com.example.common.FirstTableModel

interface LocalDatabase {

    suspend fun fetchData(): List<FirstTableModel>?

    suspend fun addData(firstTableModel: FirstTableModel)
}