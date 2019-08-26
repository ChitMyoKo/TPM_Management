package com.tpm.batch1.network.network_response.activities

import com.google.gson.annotations.SerializedName

data class Activity(
    @SerializedName("activityId")
    val activityId: Int,
    @SerializedName("batchId")
    val batchId: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("posttime")
    val posttime: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String
)