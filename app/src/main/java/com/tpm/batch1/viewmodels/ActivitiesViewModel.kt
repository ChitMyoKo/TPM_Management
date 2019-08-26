package com.tpm.batch1.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.ActivitiesRepository.ActivitiesRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class ActivitiesViewModel(
    private val activityRepo: ActivitiesRepository
) : BaseViewModel() {
    var activityListGetSuccessState = MutableLiveData<List<com.tpm.batch1.network.network_response.activities.Activity>>()
    var activityListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList()
    {
        launch {
            activityRepo.getActivitiesList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    activityListGetSuccessState.postValue(it)
                    Log.d("size of activityList", it.size.toString())
                },{
                    activityListGetErrorState.value = it.localizedMessage
                    Log.d("err enquee", it.localizedMessage)
                })
        }
    }
}