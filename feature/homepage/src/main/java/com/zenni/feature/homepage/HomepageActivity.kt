package com.zenni.feature.homepage

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zenni.api_feature.ProfileService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomepageActivity : AppCompatActivity() {

    @Inject
    lateinit var profileService: ProfileService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val btn = findViewById<Button>(R.id.homepage_text)
        btn.setOnClickListener {
            startActivity(profileService.createProfilePageIntent(this@HomepageActivity))
        }

        val btnProfile = findViewById<Button>(R.id.get_user_info)
        btnProfile.setOnClickListener {
            val info = profileService.getUserInfo()
            Toast.makeText(this@HomepageActivity, info.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}