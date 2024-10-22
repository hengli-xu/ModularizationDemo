package com.zenni.core.network.retrofit;

import com.zenni.core.network.ZenniNetworkDataSource
import com.zenni.core.network.model.NetworkFrameResource
import com.zenni.core.network.model.NetworkFrameSku
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitZenniNetwork @Inject constructor(

) : ZenniNetworkDataSource {

    override suspend fun getFrameResources(): Flow<List<NetworkFrameResource>> {
        return flow {
            emit(DEFAULT_FRAME_LIST_1)
            delay(2_000L)
            emit(DEFAULT_FRAME_LIST_2)
        }
    }

    companion object {
        val DEFAULT_FRAME_LIST_1 = listOf(
            NetworkFrameResource(
                id = "frame1",
                skuList = listOf(
                    NetworkFrameSku("sku11", 6.95),
                    NetworkFrameSku("sku12", 15.95),
                )
            ),
            NetworkFrameResource(
                id = "frame2",
                skuList = listOf(
                    NetworkFrameSku("sku21", 8.95),
                    NetworkFrameSku("sku22", 32.95),
                )
            ),
        )

        val DEFAULT_FRAME_LIST_2 = listOf(
            NetworkFrameResource(
                id = "frame3",
                skuList = listOf(
                    NetworkFrameSku("sku31", 26.95),
                    NetworkFrameSku("sku32", 6.95),
                )
            ),
            NetworkFrameResource(
                id = "frame4",
                skuList = listOf(
                    NetworkFrameSku("sku41", 80.95),
                    NetworkFrameSku("sku42", 9.95),
                )
            ),
        )
    }
}
