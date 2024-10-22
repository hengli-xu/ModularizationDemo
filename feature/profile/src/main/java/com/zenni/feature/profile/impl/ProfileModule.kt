package com.zenni.feature.profile.impl

import com.zenni.core.api_feature.ProfileApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProfileModule {
    @Binds
    abstract fun bindsService(
        impl: ProfileApiImpl
    ): ProfileApi
}