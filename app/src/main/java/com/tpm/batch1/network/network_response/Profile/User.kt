package com.tpm.batch1.network.network_response.Profile

import com.google.gson.annotations.SerializedName

class User
{
    @SerializedName("password")
    val password: String? = null
    @SerializedName("userId")
    val userId: Int?= null
    @SerializedName("userName")
    val userName: String? = null
}