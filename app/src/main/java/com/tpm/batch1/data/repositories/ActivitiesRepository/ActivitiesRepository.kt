package com.tpm.batch1.data.repositories.ActivitiesRepository

import com.tpm.batch1.network.network_response.Activity
import io.reactivex.Observable

interface ActivitiesRepository {

    fun getActivitiesList() : Observable<List<com.tpm.batch1.network.network_response.activities.Activity>>
}