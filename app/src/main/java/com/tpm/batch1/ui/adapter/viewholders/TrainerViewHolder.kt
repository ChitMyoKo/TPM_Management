package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tpm.batch1.network.network_response.Trainer
import kotlinx.android.synthetic.main.trainer.view.*

class TrainerViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view){
    fun setData(data : com.tpm.batch1.network.network_response.trainer.Trainer)
    {
        view.apply {
            tvTrainerName.text = data.firstName + " "+ data.lastName
            tvTrainerJob.text = data.position
            tvTrainerEmail.text = data.email
            tvTrainerPhoneNumber.text = data.phone
            Picasso.get().load(data.imgLink).into(ivTrainerProfile)
        }
    }
}