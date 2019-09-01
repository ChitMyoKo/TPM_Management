package com.tpm.batch1.network.network_response.learning_material

import com.google.gson.annotations.SerializedName

data class LearningMaterial(
    @SerializedName("batchId")
    val batchId: Int? = null,
    @SerializedName("courseId")
    val courseId: Int? = null,
    @SerializedName("fileId")
    val fileId: Int? = null,
    @SerializedName("fileLink")
    val fileLink: String? = null,
    @SerializedName("fileName")
    val fileName: String? = null,
    @SerializedName("trackId")
    val trackId: Int? = null,
    @SerializedName("trainerId")
    val trainerId: Int? = null,
    @SerializedName("uploadTime")
    val uploadTime: Any? = null
)