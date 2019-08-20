package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepository
import com.tpm.batch1.network.network_response.CourseDetails
import io.reactivex.android.schedulers.AndroidSchedulers

class CourseDetailsViewModel(
    private val courseDetailsRepo : CourseDetailsRepository
) : BaseViewModel(){
    var courseDetailsListGetSuccessState = MutableLiveData<List<CourseDetails>>()
    var courseDetailsListGetErrorState = MutableLiveData<String>()

    fun loadCourseDetailsList()
    {
        launch {
            courseDetailsRepo.getCourseDetailsList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    courseDetailsListGetSuccessState.postValue(it)
                },{
                    courseDetailsListGetErrorState.value = it.localizedMessage
                })
        }
    }
}