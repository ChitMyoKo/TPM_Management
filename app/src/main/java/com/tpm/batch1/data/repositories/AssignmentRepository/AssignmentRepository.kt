package com.tpm.batch1.data.repositories.AssignmentRepository

import io.reactivex.Observable

interface AssignmentRepository {
    fun getAssignmentList(trackId : String) : Observable<List<com.tpm.batch1.network.network_response.assignment.Assignment>>
}