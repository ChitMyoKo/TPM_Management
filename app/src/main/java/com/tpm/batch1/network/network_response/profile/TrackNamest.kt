package com.tpm.batch1.network.network_response.profile

import com.google.gson.annotations.SerializedName

data class TrackNamest(
    @SerializedName("trackId")
    val trackId: Int? = null,
    @SerializedName("trackName")
    val trackName: String? = null
)