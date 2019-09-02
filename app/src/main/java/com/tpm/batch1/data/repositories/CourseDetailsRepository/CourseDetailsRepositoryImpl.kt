package com.tpm.batch1.data.repositories.CourseDetailsRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.course.Course
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class CourseDetailsRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : CourseDetailsRepository{
    override fun getCourseDetailsList(trackId: String): Observable<List<Course>> {
        if(Utils.isOnline(context))
        {
            return apiService.loadCourseList(trackId)
        }
        else
        {
            return apiService.loadCourseList(trackId)
        }
    }

}