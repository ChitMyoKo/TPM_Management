package com.tpm.batch1.network.network_response.trainer

import com.google.gson.annotations.SerializedName

data class Trainer(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("imgLink")
    val imgLink: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("position")
    val position: String? = null
)