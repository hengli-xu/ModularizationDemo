package com.zenni.feature.profile.service

import com.zenni.api_feature.ProfileService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProfileModule {
    @Binds
    abstract fun bindsService(
        impl: ProfileServiceImpl
    ): ProfileService
}