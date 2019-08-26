package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.AssignmentRepository.AssignmentRepository
import com.tpm.batch1.network.network_response.Activity
import com.tpm.batch1.network.network_response.Assignment
import io.reactivex.android.schedulers.AndroidSchedulers

class AssignmentViewModel(
    private val assignmentRepo : AssignmentRepository
) : BaseViewModel(){
    var assignmentListGetSuccessState = MutableLiveData<List<Assignment>>()
    var assignmentListGetErrorState = MutableLiveData<String>()

    fun loadAssignmentList()
    {
        launch {
            assignmentRepo.getAssignmentList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    assignmentListGetSuccessState.postValue(it)
                },{
                    assignmentListGetErrorState.value = it.localizedMessage
                })
        }
    }
}