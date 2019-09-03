package com.tpm.batch1.network.network_response.profile

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrackNamest(
    @SerializedName("trackId")
    val trackId: Int? = null,
    @SerializedName("trackName")
    val trackName: String? = null
): Serializable