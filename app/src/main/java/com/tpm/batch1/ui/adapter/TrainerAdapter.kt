package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.Trainer
import com.tpm.batch1.ui.adapter.viewholders.TrainerViewHolder

class TrainerAdapter : RecyclerView.Adapter<TrainerViewHolder>() {
    private var trainerList = emptyList<com.tpm.batch1.network.network_response.trainer.Trainer>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.trainer,parent,false)
        return TrainerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.trainerList.count()
    }

    override fun onBindViewHolder(holder: TrainerViewHolder, position: Int) {
        holder.setData(this.trainerList[position])
    }

    fun setTrainerList(trainerList: List<com.tpm.batch1.network.network_response.trainer.Trainer>)
    {
        this.trainerList = trainerList
        notifyDataSetChanged()
    }
}