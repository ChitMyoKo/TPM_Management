package com.tpm.batch1.data.repositories.ActivitiesDetailsRepository

import com.tpm.batch1.network.network_response.Activity
import io.reactivex.Observable

interface ActivitiesDetailsRepository {
    fun getActivity() : Observable<Activity>
}