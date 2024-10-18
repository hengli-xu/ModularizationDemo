package com.zenni.feature.profile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zenni.api_feature.HomepageService
import com.zenni.api_feature.ProfileService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var homepageService: HomepageService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<TextView>(R.id.homepage_text).text = homepageService.getHomepageLabel()
    }
}