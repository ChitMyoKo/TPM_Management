package com.tpm.batch1.network.network_response.course

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("courseId")
    val courseId: Int? = null,
    @SerializedName("courseName")
    val courseName: String? = null,
    @SerializedName("day")
    val day: String? = null,
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("endTime")
    val endTime: Any? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("startTime")
    val startTime: Any? = null,
    @SerializedName("trackId")
    val trackId: Int?  = null,
    @SerializedName("trainerId")
    val trainerId: Int? = null
)