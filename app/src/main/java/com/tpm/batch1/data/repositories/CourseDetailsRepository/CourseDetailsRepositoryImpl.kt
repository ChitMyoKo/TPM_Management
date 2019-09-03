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
    val c1 = Course(2,"Android Development","Mon,Tue,Fri","2-11-2019","2:10pm","Mr Mg","Mg","2-10-2019","1:23am",1,3)
    val c2 = Course(2,"Android Development","Mon,Tue,Fri","2-11-2019","2:10pm","Ms Ma","Ma","2-10-2019","1:23am",1,3)
    var cList = mutableListOf<Course>(c1,c2)
    override fun getCourseDetailsList(trackId: String): Observable<List<Course>> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(cList)
            return apiService.loadCourseList(trackId)
        }
        else
        {
            return Observable.just(cList)
        }
    }

}