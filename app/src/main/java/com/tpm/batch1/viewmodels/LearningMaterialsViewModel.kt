package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.LearningMaterials.LearningMaterialsRepository
import com.tpm.batch1.network.network_response.LearningMaterial
import io.reactivex.android.schedulers.AndroidSchedulers

class LearningMaterialsViewModel(
    private val learningMaterialsRepo : LearningMaterialsRepository
) : BaseViewModel(){
    var materialsListGetSuccessState = MutableLiveData<List<LearningMaterial>>()
    var materialsListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList()
    {
        launch {
            learningMaterialsRepo.getMaterialsList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    materialsListGetSuccessState.postValue(it)
                },{
                    materialsListGetErrorState.value = it.localizedMessage
                })
        }
    }
}