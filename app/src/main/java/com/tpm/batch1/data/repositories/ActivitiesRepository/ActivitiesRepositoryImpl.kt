package com.tpm.batch1.data.repositories.ActivitiesRepository

import android.content.Context
import android.util.Log
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.Activity
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ActivitiesRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : ActivitiesRepository {
    var a1 = Activity("Sayar U Thein Oo","Don't wait opportuniy,Create it!", R.drawable.user)
    var a2 = Activity("Sayar U Thein Oo","Don't wait opportuniy,Create it!", R.drawable.user)
    var aList = mutableListOf<Activity>(a1,a2)
    override fun getActivitiesList(): Observable<List<com.tpm.batch1.network.network_response.activities.Activity>> {
        if(Utils.isOnline(context))
        {
            Log.d("have conn","****")
            return apiService.loadActivityList()
        }
        else{
            Log.d("have not conn","****")
            return apiService.loadActivityList()
        }
    }
}