package com.zenni.feature.homepage.service

import com.zenni.api_feature.HomepageService
import javax.inject.Inject

class HomepageServiceImpl @Inject constructor() : HomepageService {
    override fun getHomepageLabel(): String {
        return "Homepage module string"
    }
}