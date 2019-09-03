package com.tpm.batch1.data.repositories.AssignmentRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class AssignmentRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : AssignmentRepository{

    var ass1 = com.tpm.batch1.network.network_response.assignment.Assignment(1,1,1,1,"Write mvvm architecture..","MVVM",1,"19-9-2019")
    var ass2 = com.tpm.batch1.network.network_response.assignment.Assignment(1,1,1,1,"Write mvp architecture..","MVP",1,"19-9-2019")
    var asList = mutableListOf<com.tpm.batch1.network.network_response.assignment.Assignment>(ass1,ass2)
    override fun getAssignmentList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.assignment.Assignment>> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(asList)
            return apiService.loadAssignmentList(trackId)
        }
        else
        {
            return Observable.just(asList)
        }
    }
}