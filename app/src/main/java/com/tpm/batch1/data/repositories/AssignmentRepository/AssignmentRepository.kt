package com.tpm.batch1.data.repositories.AssignmentRepository

import com.tpm.batch1.network.network_response.Assignment
import io.reactivex.Observable

interface AssignmentRepository {
    fun getAssignmentList() : Observable<List<Assignment>>
}