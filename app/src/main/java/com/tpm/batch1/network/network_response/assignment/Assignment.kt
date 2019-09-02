package com.tpm.batch1.network.network_response.assignment

data class Assignment(
    val assignmentFile: Int,
    val assignmentId: Int,
    val batchId: Int,
    val courseId: Int,
    val description: String,
    val title: String,
    val trackId: Int,
    val uploadTime: String
)