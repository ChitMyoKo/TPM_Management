package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.AssignmentRepository.AssignmentRepository
import com.tpm.batch1.network.network_response.Assignment
import io.reactivex.android.schedulers.AndroidSchedulers

class AssignmentViewModel(
    private val assignmentRepo : AssignmentRepository
) : BaseViewModel(){
    var assignmentListGetSuccessState = MutableLiveData<List<com.tpm.batch1.network.network_response.assignment.Assignment>>()
    var assignmentListGetErrorState = MutableLiveData<String>()

    fun loadAssignmentList(trackId: String)
    {
        launch {
            assignmentRepo.getAssignmentList(trackId)
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