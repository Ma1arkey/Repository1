package com.dedenko.di



import com.dedenko.storage.DataStorage
import com.dedenko.storage.DataStorageUse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindDataStorage(dataStorageUse: DataStorageUse) : DataStorage

}