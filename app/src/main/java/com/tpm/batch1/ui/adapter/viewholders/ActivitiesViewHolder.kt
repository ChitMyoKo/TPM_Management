package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Activity
import kotlinx.android.synthetic.main.activities.view.*

class ActivitiesViewHolder(
    private val view: View,
    private val onClickActivity: (activity : com.tpm.batch1.network.network_response.activities.Activity)->Unit
): RecyclerView.ViewHolder(view) {
    fun setData(activity: com.tpm.batch1.network.network_response.activities.Activity)
    {
        view.apply {
            /*tvActivityTitle.text = activity.activityTitle
            tvActivityDescr.text = activity.activityDesc
            ivActivityImage.setImageResource(activity.activityImage)*/
            tvActivityTitle.text = activity.title
            if(activity.text.toString().length > 40)
                tvActivityDescr.text = activity.text.toString().substring(0,40)+"..."
            else
                tvActivityDescr.text = activity.text
            //Picasso.get().load(activity.imageLink).into(ivActivityImage)
            Picasso.get().load(activity.picture).into(ivActivityImage)
           // Glide.with(context).load(activity.imageLink).into(ivActivityImage)
           // ivActivityImage.setImageResource(R.drawable.user)
        }
        view.setOnClickListener {
            onClickActivity(activity)
        }
    }
}