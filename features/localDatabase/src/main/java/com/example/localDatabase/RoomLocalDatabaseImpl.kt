package com.example.localDatabase

import com.example.common.FirstTableModel
import javax.inject.Inject

internal class RoomLocalDatabaseImpl @Inject constructor(
    val roomLocalDatabase: RoomLocalDatabase
): LocalDatabase {

    override suspend fun fetchData(): List<FirstTableModel>? {

        val data = roomLocalDatabase.firstTableDAO().fetchData()

        return data?.map {

            FirstTableModel(
                id = it.id,
                intValue = it.intValue,
                stringValue = it.stringValue
            )
        }
    }

    override suspend fun addData(firstTableModel: FirstTableModel) {

        val firstTableEntity = FirstTableEntity(
            id = firstTableModel.id,
            intValue = firstTableModel.intValue,
            stringValue = firstTableModel.stringValue
        )

        roomLocalDatabase.firstTableDAO().addData(firstTableEntity)
    }
}