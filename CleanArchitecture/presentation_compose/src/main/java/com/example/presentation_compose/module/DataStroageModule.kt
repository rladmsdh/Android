package com.example.presentation_compose.module

import com.example.data.data.storage.UserDataStorage
import com.example.data.data.storage.UserDataStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStroageModule {
    @Binds
    abstract fun provideUserDataStorage(
        userDataStorageImpl: UserDataStorageImpl,
    ): UserDataStorage
}