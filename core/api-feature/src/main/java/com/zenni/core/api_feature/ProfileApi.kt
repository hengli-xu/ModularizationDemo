package com.zenni.core.api_feature

import android.content.Context
import android.content.Intent
import com.zenni.core.datamodel.profile.ProfileInfo

interface ProfileApi {
    fun createProfilePageIntent(context: Context): Intent

    fun getUserInfo(): ProfileInfo
}
