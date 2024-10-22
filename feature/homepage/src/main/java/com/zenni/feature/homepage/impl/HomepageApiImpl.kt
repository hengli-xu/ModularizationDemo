package com.zenni.feature.homepage.impl

import com.zenni.core.api_feature.HomepageApi
import javax.inject.Inject

class HomepageApiImpl @Inject constructor() : HomepageApi {
    override fun getHomepageLabel(): String {
        return "Homepage module string"
    }
}
