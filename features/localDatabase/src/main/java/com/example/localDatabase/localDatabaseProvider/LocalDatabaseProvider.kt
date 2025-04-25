package com.example.localDatabase.localDatabaseProvider

import com.example.localDatabase.LocalDatabase
import com.example.localDatabase.RoomLocalDatabase
import com.example.localDatabase.RoomLocalDatabaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class LocalDatabaseProvider {

    @Provides
    @Singleton
    fun provideLocalDatabaseImpl(roomLocalDatabase: RoomLocalDatabase): LocalDatabase =
        RoomLocalDatabaseImpl(roomLocalDatabase = roomLocalDatabase)
}