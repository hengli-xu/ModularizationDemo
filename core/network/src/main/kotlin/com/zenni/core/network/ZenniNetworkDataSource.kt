package com.zenni.core.network

import com.zenni.core.network.model.NetworkFrameResource
import kotlinx.coroutines.flow.Flow

interface ZenniNetworkDataSource {

    suspend fun getFrameResources(): Flow<List<NetworkFrameResource>>
}
