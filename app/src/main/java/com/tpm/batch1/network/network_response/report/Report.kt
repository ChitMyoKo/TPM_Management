package com.tpm.batch1.network.network_response.report

import com.google.gson.annotations.SerializedName

data class Report(
    @SerializedName("code")
    val code: Int,
    @SerializedName("messagae")
    val message: String
)