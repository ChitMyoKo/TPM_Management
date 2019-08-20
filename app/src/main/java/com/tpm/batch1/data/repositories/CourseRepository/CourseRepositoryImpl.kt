package com.tpm.batch1.data.repositories.CourseRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class CourseRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
): CourseRepository {
    override fun getCourseList(): Observable<List<String>> {
        var courseList = mutableListOf<String>("Android Development Course","Design Development Course")
        if(!Utils.isOnline(context))
        {
         return Observable.just(courseList)
        }
        else
        {
         return Observable.just(courseList)
        }
    }
}