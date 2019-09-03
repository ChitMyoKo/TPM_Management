package com.tpm.batch1.network.network_response.assignment

import com.google.gson.annotations.SerializedName

data class Assignment(
    @SerializedName("assignmentFile")
    val assignmentFile: Int? = null,
    @SerializedName("assignmentId")
    val assignmentId: Int? = null,
    @SerializedName("batchId")
    val batchId: Int? = null,
    @SerializedName("courseId")
    val courseId: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("trackId")
    val trackId: Int? = null,
    @SerializedName("uploadTime")
    val uploadTime: String? = null
)