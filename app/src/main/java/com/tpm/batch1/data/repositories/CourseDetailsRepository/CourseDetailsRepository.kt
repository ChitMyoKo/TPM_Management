package com.tpm.batch1.data.repositories.CourseDetailsRepository

import com.tpm.batch1.network.network_response.Course
import com.tpm.batch1.network.network_response.CourseDetails
import io.reactivex.Observable

interface CourseDetailsRepository {

    fun getCourseDetailsList(): Observable<List<CourseDetails>>
}