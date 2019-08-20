package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.Trainer
import kotlinx.android.synthetic.main.trainer.view.*

class TrainerViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view){
    fun setData(data : Trainer)
    {
        view.apply {
            tvTrainerName.text = data.trainerName
            tvTrainerJob.text = data.trainerJob
            tvTrainerEmail.text = data.trainerEmail
            tvTrainerPhoneNumber.text = data.trainerPhoneNumber
            ivTrainerProfile.setImageResource(data.trainerProfile)
        }
    }
}