package com.tpm.batch1.network.network_response.profile

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("userName")
    val userName: String? = null
): Serializable