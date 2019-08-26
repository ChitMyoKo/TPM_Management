package com.tpm.batch1.network

import com.tpm.batch1.network.network_response.activities.Activity
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("talent-management-system/api/getactivities")
    fun loadActivityList(): Observable<List<Activity>>

}