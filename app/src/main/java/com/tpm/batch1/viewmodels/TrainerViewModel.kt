package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.TrainerRepository.TrainerRepository
import com.tpm.batch1.network.network_response.Trainer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TrainerViewModel(
    private val trainerRepo : TrainerRepository
) : BaseViewModel() {

    var trainerListGetSuccessState = MutableLiveData<List<Trainer>>()
    var trainerListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList()
    {
        launch {
            trainerRepo.getTrainerList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    trainerListGetSuccessState.postValue(it)
                },{
                    trainerListGetErrorState.value = it.localizedMessage
                })
        }
    }
}