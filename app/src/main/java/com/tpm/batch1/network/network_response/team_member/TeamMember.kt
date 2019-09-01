package com.tpm.batch1.network.network_response.team_member

import com.google.gson.annotations.SerializedName
 class TeamMember(
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
    @SerializedName("trackName")
    val trackName: String? =null
)