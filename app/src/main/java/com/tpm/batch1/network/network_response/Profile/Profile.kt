package com.tpm.batch1.network.network_response.Profile

import com.google.gson.annotations.SerializedName

class Profile(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("batch")
    val batch: Batch? = null,
    @SerializedName("dateofbirth")
    val dateofbirth: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("fbLink")
    val fbLink: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("imageCode")
    val imageCode: Int? = null,
    @SerializedName("img_link")
    val img_link: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("nrc")
    val nrc: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("qualification")
    val qualification: String?= null,
    @SerializedName("studentId")
    val studentId: Int? = null,
    @SerializedName("trackName")
    val tarckName: Any? = null,
    @SerializedName("team_id")
    val team_id: String?= null,
    @SerializedName("track")
    val track: Int? = null,
    @SerializedName("user")
    val user: User?= null
    ){

}