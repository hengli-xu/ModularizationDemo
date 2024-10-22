package com.zenni.core.data.repository

import com.zenni.core.datamodel.frame.Frame
import com.zenni.core.network.ZenniNetworkDataSource
import com.zenni.core.network.model.NetworkFrameResource
import com.zenni.core.network.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlgoliaFrameRepository @Inject constructor(
    private val zenniNetworkDataSource: ZenniNetworkDataSource,
) : FrameRepository {

    override suspend fun getFrameResources(
        query: FrameResourceQuery
    ): Flow<List<Frame>> {
        return zenniNetworkDataSource.getFrameResources()
            .map {
                it.map(NetworkFrameResource::asExternalModel)
                    .mapNotNull { frame ->
                        val skuList = frame.skuList.filter { sku ->
                            query.filterFrameSkuPriceRange?.contains(sku.price) ?: true
                        }
                        if (skuList.isNotEmpty()) {
                            frame.copy(skuList = skuList)
                        } else {
                            null
                        }
                    }
            }
    }
}
