package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.course.Course
import com.tpm.batch1.ui.adapter.viewholders.CourseDetailsViewHolder

class CourseDetailsAdapter: RecyclerView.Adapter<CourseDetailsViewHolder>() {
    private var courseDetailsList = emptyList<Course>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_details,parent,false)
        return CourseDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.courseDetailsList.count()
    }

    override fun onBindViewHolder(holder: CourseDetailsViewHolder, position: Int) {
        holder.setData(this.courseDetailsList[position])
    }

    fun setCourseDetailsList(courseDetailsList : List<Course>)
    {
        this.courseDetailsList = courseDetailsList
        notifyDataSetChanged()
    }
}