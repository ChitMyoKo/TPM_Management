package com.tpm.batch1.network.network_response.P

data class Batch(
    val batchId: Int,
    val batchName: String,
    val endDate: Long,
    val startDate: Long
)