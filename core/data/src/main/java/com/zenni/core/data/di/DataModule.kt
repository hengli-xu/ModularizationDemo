package com.zenni.core.data.di

import com.zenni.core.data.repository.AlgoliaFrameRepository
import com.zenni.core.data.repository.FrameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsFrameRepository(
        frameRepository: AlgoliaFrameRepository,
    ): FrameRepository
}
