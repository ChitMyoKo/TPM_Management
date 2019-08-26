package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepository
import com.tpm.batch1.network.network_response.Activity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ActivitiesDetailsViewModel(
    private val activityDetailsRepo : ActivitiesDetailsRepository
) : BaseViewModel() {
    var activityGetSuccessState = MutableLiveData<Activity>()
    var activityGetErrorState = MutableLiveData<String>()

    fun loadActivity()
    {
        launch {
            activityDetailsRepo.getActivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        activityGetSuccessState.postValue(it)
                    },
                    {
                        activityGetErrorState.value = it.localizedMessage
                    }
                )
        }
    }
}