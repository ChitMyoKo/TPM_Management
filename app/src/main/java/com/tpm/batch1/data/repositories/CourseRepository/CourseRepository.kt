package com.tpm.batch1.data.repositories.CourseRepository

import io.reactivex.Observable

interface CourseRepository {

    fun getCourseList() : Observable<List<String>>
}