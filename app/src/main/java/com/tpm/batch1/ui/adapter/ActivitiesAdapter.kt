package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Activity
import com.tpm.batch1.ui.adapter.viewholders.ActivitiesViewHolder

class ActivitiesAdapter(
    private val onClickActivity : (activity: com.tpm.batch1.network.network_response.activities.Activity) ->Unit
) : RecyclerView.Adapter<ActivitiesViewHolder>() {
    private var activityList = emptyList<com.tpm.batch1.network.network_response.activities.Activity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activities,parent,false)
        return ActivitiesViewHolder(view,onClickActivity)
    }

    override fun getItemCount(): Int {
        return this.activityList.count()
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.setData(this.activityList[position])
    }
    fun setActivityList(activityList: List<com.tpm.batch1.network.network_response.activities.Activity>)
    {
        this.activityList = activityList
        notifyDataSetChanged()
    }

}