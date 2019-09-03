package com.tpm.batch1.network.network_response.profile

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Batch(
    @SerializedName("batchId")
    val batchId: Int? = null,
    @SerializedName("batchName")
    val batchName: String? = null,
    @SerializedName("endDate")
    val endDate: Long? = null,
    @SerializedName("startDate")
    val startDate: Long? = null
): Serializable