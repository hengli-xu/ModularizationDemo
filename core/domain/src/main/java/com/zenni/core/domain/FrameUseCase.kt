package com.zenni.core.domain

import com.zenni.core.data.repository.FrameRepository
import com.zenni.core.data.repository.FrameResourceQuery
import com.zenni.core.datamodel.frame.Frame
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FrameUseCase @Inject constructor(
    private val frameRepository: FrameRepository
) {
    suspend fun getFrameResources(
        query: FrameResourceQuery = FrameResourceQuery(filterFrameSkuPriceRange = null)
    ): Flow<List<Frame>> {
        return frameRepository.getFrameResources(query)
    }
}
