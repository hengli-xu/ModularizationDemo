package com.zenni.api_feature

import android.content.Context
import android.content.Intent
import com.zenni.datamodel.ProfileInfo

interface ProfileService {
    fun createProfilePageIntent(context: Context): Intent

    fun getUserInfo(): ProfileInfo
}