package com.tpm.batch1.data.repositories.CourseDetailsRepository

import io.reactivex.Observable

interface CourseDetailsRepository {

    fun getCourseDetailsList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.course.Course>>
}