package com.example.localDatabase.localDatabaseProvider

import android.content.Context
import androidx.room.Room
import com.example.localDatabase.RoomLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RoomLocalDatabaseProvider {

    @Provides
    @Singleton
    fun provideRoomLocalDatabase(@ApplicationContext context: Context): RoomLocalDatabase =
        Room.databaseBuilder(
            context = context,
            klass = RoomLocalDatabase::class.java,
            name = "database-name"
        ).build()
}