package com.tpm.batch1.data.repositories.AssignmentRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.Assignment
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class AssignmentRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : AssignmentRepository{
    var as1 = Assignment("as1","Kotlin Programming","Write any logic",false,"21-9-19")
    var as2 = Assignment("as1","Kotlin Programming","Write any logic",false,"21-9-19")
    var asList = mutableListOf<Assignment>(as1,as2)
    override fun getAssignmentList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.assignment.Assignment>> {
        if(Utils.isOnline(context))
        {
            return apiService.loadAssignmentList(trackId)
        }
        else
        {
            return apiService.loadAssignmentList(trackId)
        }
    }
}