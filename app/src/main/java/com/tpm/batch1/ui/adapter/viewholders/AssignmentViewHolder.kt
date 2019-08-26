package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.Assignment
import kotlinx.android.synthetic.main.assignment.view.*

class AssignmentViewHolder(
    private val view:View,
    private val uploadZipFile: () -> Unit
) : RecyclerView.ViewHolder(view){
    fun setData(assignment: Assignment)
    {
        view.apply {
            tvAssignmentTitle.text = assignment.assignmentTitle
            tvAssignmentDescr.text = assignment.assignmentDesc
            tvUploadStatus.text = "Need to submit"
            tvUploadDate.text = assignment.uploadDate
            btnUploadZipFile.setOnClickListener {
                uploadZipFile()
            }
        }
    }
}