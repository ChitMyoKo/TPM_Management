package com.tpm.batch1.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CourseViewModel(
    private val courseRepo : CourseRepository
) : BaseViewModel(){

    var courseListGetSuccessState = MutableLiveData<List<String>>()
    var courseListGetErrorState = MutableLiveData<String>()

    fun loadCourseList()
    {
        launch {
            courseRepo.getCourseList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        courseListGetSuccessState.postValue(it)
                    },
                    {
                        courseListGetErrorState.value = it.localizedMessage
                    }
                )
        }
    }
}