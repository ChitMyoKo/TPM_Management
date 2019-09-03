package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.assignment.view.*

class AssignmentViewHolder(
    private val view:View,
    private val uploadZipFile: () -> Unit
) : RecyclerView.ViewHolder(view){
    fun setData(assignment: com.tpm.batch1.network.network_response.assignment.Assignment)
    {
        view.apply {
            tvAssignmentTitle.text = assignment.title
            tvAssignmentDescr.text = assignment.description
            //tvUploadStatus.text = "Need to submit"
            tvUploadDate.text = assignment.uploadTime
          /*  btnUploadZipFile.setOnClickListener {
                uploadZipFile()
            }*/
        }
    }
}