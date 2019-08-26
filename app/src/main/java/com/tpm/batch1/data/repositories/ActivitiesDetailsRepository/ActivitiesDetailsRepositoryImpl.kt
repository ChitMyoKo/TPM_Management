package com.tpm.batch1.data.repositories.ActivitiesDetailsRepository

import android.content.Context
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.Activity
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ActivitiesDetailsRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
): ActivitiesDetailsRepository {
    var a1 = Activity("Sayar U Thein Oo","Don't wait opportuniy,Create it!", R.drawable.user)
    override fun getActivity(): Observable<Activity> {
        if(Utils.isOnline(context))
        {
            return Observable.just(a1)
        }
        else
        {
            return Observable.just(a1)
        }
    }
}