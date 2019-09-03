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
            var day = courseDetails.day!!.split(",")

            if(day.size == 0)
            {
                fDay.visibility = View.INVISIBLE
                bgMon.visibility = View.INVISIBLE
                sDay.visibility = View.INVISIBLE
                bgTue.visibility = View.INVISIBLE
                tDay.visibility = View.INVISIBLE
                bgWed.visibility = View.INVISIBLE
                fourDay.visibility = View.INVISIBLE
                bgThu.visibility = View.INVISIBLE
                ffDay.visibility = View.INVISIBLE
                bgFri.visibility = View.INVISIBLE
            }
            if(day.size == 1)
            {
                fDay.text = day[0]
                sDay.visibility = View.INVISIBLE
                bgTue.visibility = View.INVISIBLE
                tDay.visibility = View.INVISIBLE
                bgWed.visibility = View.INVISIBLE
                fourDay.visibility = View.INVISIBLE
                bgThu.visibility = View.INVISIBLE
                ffDay.visibility = View.INVISIBLE
                bgFri.visibility = View.INVISIBLE
            }
            if(day.size == 2)
            {
                fDay.text = day[0]
                sDay.text = day[1]
                tDay.visibility = View.INVISIBLE
                bgWed.visibility = View.INVISIBLE
                fourDay.visibility = View.INVISIBLE
                bgThu.visibility = View.INVISIBLE
                ffDay.visibility = View.INVISIBLE
                bgFri.visibility = View.INVISIBLE
            }
            if(day.size == 3)
            {
                fDay.text = day[0]
                sDay.text = day[1]
                tDay.text = day[2]
                fourDay.visibility = View.INVISIBLE
                bgThu.visibility = View.INVISIBLE
                ffDay.visibility = View.INVISIBLE
                bgFri.visibility = View.INVISIBLE
            }
            if(day.size == 4)
            {
                fDay.text = day[0]
                sDay.text = day[1]
                tDay.text = day[2]
                fourDay.text = day[3]
                ffDay.visibility = View.INVISIBLE
                bgFri.visibility = View.INVISIBLE
            }
            if(day.size == 5)
            {
                fDay.text = day[0]
                sDay.text = day[1]
                tDay.text = day[2]
                fourDay.text = day[3]
                ffDay.text = day[4]
            }
        }
    }
}