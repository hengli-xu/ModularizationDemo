package com.zenni.feature.profile.service

import android.content.Context
import android.content.Intent
import com.zenni.api_feature.ProfileService
import com.zenni.datamodel.ProfileInfo
import com.zenni.feature.profile.ProfileActivity
import javax.inject.Inject

class ProfileServiceImpl @Inject constructor() : ProfileService {
    override fun createProfilePageIntent(context: Context): Intent {
        return Intent(context, ProfileActivity::class.java)
    }

    override fun getUserInfo(): ProfileInfo {
        return ProfileInfo(
            name = "xiaoming",
            nickname = "xm",
            avator = "https://pih-cdn.zenniservices.com/v1/images/homepage-v6-assets/production/ShopBy/shop-by-image-15-3x.png"
        )
    }
}