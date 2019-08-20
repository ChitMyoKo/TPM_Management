package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course.view.*

class CourseViewHolder(
    private val view: View,
    private val onClickItem:()-> Unit
) : RecyclerView.ViewHolder(view){
    fun setData(courseName : String)
    {
        view.apply {
            tvCourseName.text = courseName
        }
        view.setOnClickListener {
            onClickItem()
        }
    }
}