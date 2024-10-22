package com.zenni.feature.profile.impl

import android.content.Context
import android.content.Intent
import com.zenni.core.api_feature.ProfileApi
import com.zenni.core.datamodel.profile.ProfileInfo
import com.zenni.feature.profile.ProfileActivity
import javax.inject.Inject

class ProfileApiImpl @Inject constructor() : ProfileApi {
    override fun createProfilePageIntent(context: Context): Intent {
        return Intent(context, ProfileActivity::class.java)
    }

    override fun getUserInfo(): ProfileInfo {
        return ProfileInfo(
            name = "xiaoming",
            nickname = "xm",
            avatar = "https://pih-cdn.zenniservices.com/v1/images/homepage-v6-assets/production/ShopBy/shop-by-image-15-3x.png"
        )
    }
}
