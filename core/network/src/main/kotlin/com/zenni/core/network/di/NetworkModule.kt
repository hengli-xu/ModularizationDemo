package com.zenni.core.network.di

import com.zenni.core.network.ZenniNetworkDataSource
import com.zenni.core.network.retrofit.RetrofitZenniNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindZenniNetworkDataSource(
        retrofitZenniNetwork: RetrofitZenniNetwork
    ): ZenniNetworkDataSource
}
