package com.zenni.core.network.model

import com.zenni.core.datamodel.frame.Frame
import com.zenni.core.datamodel.frame.FrameSku
import kotlinx.serialization.Serializable

@Serializable
data class NetworkFrameResource(
    val id: String,
    val skuList: List<NetworkFrameSku>,
)

@Serializable
data class NetworkFrameSku(
    val id: String,
    val price: Double,
)

fun NetworkFrameResource.asExternalModel() = Frame(
    id = id,
    skuList = skuList.map { it.asExternalModel() }
)

fun NetworkFrameSku.asExternalModel() = FrameSku(
    id = id,
    price = price,
)
