package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Trainer
import com.tpm.batch1.ui.adapter.viewholders.CourseViewHolder

class CourseAdapter(
    private val onClickItem: () -> Unit
) : RecyclerView.Adapter<CourseViewHolder>() {
    private var courseList = emptyList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course,parent,false)
        return CourseViewHolder(view,onClickItem)
    }

    override fun getItemCount(): Int {
        return this.courseList.count()
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.setData(this.courseList[position])
    }

    fun setCourseList( courseList : List<String>)
    {
        this.courseList = courseList
        notifyDataSetChanged()
    }
}