package com.zenni.feature.homepage.impl

import com.zenni.core.api_feature.HomepageApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class HomepageModule {
    @Binds
    abstract fun bindsHomePageApi(
        impl: HomepageApiImpl
    ): HomepageApi
}
