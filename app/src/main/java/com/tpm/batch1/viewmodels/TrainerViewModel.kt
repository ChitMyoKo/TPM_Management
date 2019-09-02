package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.TrainerRepository.TrainerRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class TrainerViewModel(
    private val trainerRepo : TrainerRepository
) : BaseViewModel() {

    var trainerListGetSuccessState = MutableLiveData<List<com.tpm.batch1.network.network_response.trainer.Trainer>>()
    var trainerListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList(trackId: String)
    {
        launch {
            trainerRepo.getTrainerList(trackId)
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