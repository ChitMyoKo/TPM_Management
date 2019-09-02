package com.tpm.batch1.ui.adapter.viewholders

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.course.Course
import kotlinx.android.synthetic.main.course_details.view.*

class CourseDetailsViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view) {

    fun setData(courseDetails : Course)
    {
        Log.d("Name1",courseDetails.courseName)
        view.apply {
            Log.d("Name",courseDetails.courseName)
            tvCourseDetailsTitle.text = courseDetails.courseName
            tvCourseTrainerName.text = courseDetails.firstName+ " "+ courseDetails.lastName
            tvCourseStartDate.text = courseDetails.startDate
            tvCourseEndDate.text = courseDetails.endDate
        }
    }
}