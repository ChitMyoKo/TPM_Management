package com.tpm.batch1.network.network_response.activities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Activity(
    @SerializedName("activityId")
    val activityId: Int? = null,
    @SerializedName("batchId")
    val batchId: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("imageCode")
    val imageCode: Int? = null,
    @SerializedName("imageLink")
    val imageLink: String? = null,
    @SerializedName("posttime")
    val posttime: Int? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("title")
    val title: String? = null
) : Serializable
