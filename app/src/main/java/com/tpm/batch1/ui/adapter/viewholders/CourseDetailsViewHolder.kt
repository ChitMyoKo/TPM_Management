package com.tpm.batch1.ui.adapter.viewholders

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.CourseDetails
import kotlinx.android.synthetic.main.course.view.*
import kotlinx.android.synthetic.main.course_details.view.*

class CourseDetailsViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view) {

    fun setData(courseDetails : CourseDetails)
    {
        Log.d("Name1",courseDetails.courseDetailsTitle)
        view.apply {
            Log.d("Name",courseDetails.courseDetailsTitle)
            tvCourseDetailsTitle.text = courseDetails.courseDetailsTitle
            tvCourseTrainerName.text = courseDetails.courseTrainer
            tvCourseStartDate.text = courseDetails.courseStartDate
            tvCourseEndDate.text = courseDetails.courseEndDate
        }
    }
}