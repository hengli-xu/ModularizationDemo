package com.zenni.feature.homepage

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zenni.core.api_feature.ProfileApi
import com.zenni.core.base.Dispatcher
import com.zenni.core.base.Dispatchers.Default
import com.zenni.core.data.repository.FrameResourceQuery
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@AndroidEntryPoint
class HomepageActivity : AppCompatActivity() {

    @Inject
    lateinit var profileApi: ProfileApi

    @Inject
    @Dispatcher(Default)
    lateinit var defaultDispatcher: CoroutineDispatcher

    private val viewModel by viewModels<HomepageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val btn = findViewById<Button>(R.id.homepage_text)
        btn.setOnClickListener {
            startActivity(profileApi.createProfilePageIntent(this@HomepageActivity))
        }

        val btnProfile = findViewById<Button>(R.id.get_user_info)
        btnProfile.setOnClickListener {
            val info = profileApi.getUserInfo()
            Toast.makeText(this@HomepageActivity, info.toString(), Toast.LENGTH_SHORT).show()
        }

        val btnUpdatePriceRange = findViewById<Button>(R.id.btn_update_price_range)
        btnUpdatePriceRange.setOnClickListener {
            onFramePriceRangeChanged()
        }

        val frameListView = findViewById<TextView>(R.id.frame_list)
        viewModel.fetchFrameResources(
            FrameResourceQuery(
                filterFrameSkuPriceRange = (0.0).rangeTo(Double.MAX_VALUE)
            )
        )

        @Suppress("DEPRECATION")
        lifecycleScope.launchWhenStarted {
            viewModel.framesUiState.collect {
                frameListView.text = it.joinToString(", ")
            }
        }
    }

    internal fun onFramePriceRangeChanged() {
        viewModel.fetchFrameResources(
            FrameResourceQuery(
                filterFrameSkuPriceRange = (0.0).rangeTo(10.0)
            )
        )
    }
}
