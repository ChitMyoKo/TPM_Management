package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepository
import com.tpm.batch1.network.network_response.CourseDetails
import com.tpm.batch1.network.network_response.course.Course
import io.reactivex.android.schedulers.AndroidSchedulers

class CourseDetailsViewModel(
    private val courseDetailsRepo : CourseDetailsRepository
) : BaseViewModel(){
    var courseDetailsListGetSuccessState = MutableLiveData<List<Course>>()
    var courseDetailsListGetErrorState = MutableLiveData<String>()

    fun loadCourseDetailsList(trackId : String)
    {
        launch {
            courseDetailsRepo.getCourseDetailsList(trackId)
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