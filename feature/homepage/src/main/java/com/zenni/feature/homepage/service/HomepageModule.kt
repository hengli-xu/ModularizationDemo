package com.zenni.feature.homepage.service

import com.zenni.api_feature.HomepageService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class HomepageModule {
    @Binds
    abstract fun bindsService(
        impl: HomepageServiceImpl
    ): HomepageService
}