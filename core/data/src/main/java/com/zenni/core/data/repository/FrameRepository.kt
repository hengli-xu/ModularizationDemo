package com.zenni.core.data.repository

import com.zenni.core.datamodel.frame.Frame
import kotlinx.coroutines.flow.Flow

data class FrameResourceQuery(
    val filterFrameSkuPriceRange: ClosedRange<Double>? = null,
)

interface FrameRepository {
    suspend fun getFrameResources(query: FrameResourceQuery): Flow<List<Frame>>
}
