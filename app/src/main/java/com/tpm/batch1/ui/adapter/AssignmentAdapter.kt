package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Assignment
import com.tpm.batch1.ui.adapter.viewholders.AssignmentViewHolder

class AssignmentAdapter(
    private val uploadZipFile: ()-> Unit
) : RecyclerView.Adapter<AssignmentViewHolder>() {
    private var assignmentList = emptyList<com.tpm.batch1.network.network_response.assignment.Assignment>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.assignment,parent,false)
        return AssignmentViewHolder(view,uploadZipFile)
    }

    override fun getItemCount(): Int {
       return this.assignmentList.count()
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.setData(this.assignmentList[position])
    }
    fun setAssignmentList(assignmentList : List<com.tpm.batch1.network.network_response.assignment.Assignment>)
    {
        this.assignmentList = assignmentList
        notifyDataSetChanged()
    }
}