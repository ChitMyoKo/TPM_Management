package com.tpm.batch1.data.repositories.CourseDetailsRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.CourseDetails
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class CourseDetailsRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : CourseDetailsRepository{
    override fun getCourseDetailsList(): Observable<List<CourseDetails>> {
        var c1Details = CourseDetails("Kotlin Programming","Mrs Thaw Zin Aung","10-8-19","10-9-19","Mon,Fri")
        var c2Details = CourseDetails("Android Development","Mrs Thaw Zin Aung","10-8-19","10-9-19","Mon,Fri")
        var cDetailsList = mutableListOf<CourseDetails>(c1Details,c2Details)
        if(Utils.isOnline(context))
        {
            return Observable.just(cDetailsList)
        }
        else
        {
            return Observable.just(cDetailsList)
        }
    }

}