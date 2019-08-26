package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Activity
import kotlinx.android.synthetic.main.activities.view.*

class ActivitiesViewHolder(
    private val view: View,
    private val onClickActivity: ()->Unit
): RecyclerView.ViewHolder(view) {
    fun setData(activity: com.tpm.batch1.network.network_response.activities.Activity)
    {
        view.apply {
            /*tvActivityTitle.text = activity.activityTitle
            tvActivityDescr.text = activity.activityDesc
            ivActivityImage.setImageResource(activity.activityImage)*/
            tvActivityTitle.text = activity.title
            tvActivityDescr.text = activity.text
            ivActivityImage.setImageResource(R.drawable.user)
        }
        view.setOnClickListener {
            onClickActivity()
        }
    }
}