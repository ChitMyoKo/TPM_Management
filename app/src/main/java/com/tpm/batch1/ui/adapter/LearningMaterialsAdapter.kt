package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.ui.adapter.viewholders.LearningMaterialsViewHolder

class LearningMaterialsAdapter(
    private val onClickPdfOpen: (material : com.tpm.batch1.network.network_response.learning_material.LearningMaterial) -> Unit
) : RecyclerView.Adapter<LearningMaterialsViewHolder>() {
    private var materialsList = emptyList<com.tpm.batch1.network.network_response.learning_material.LearningMaterial>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningMaterialsViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.learning_materials,parent,false)
        return LearningMaterialsViewHolder(view,onClickPdfOpen)
    }

    override fun getItemCount(): Int {
        return this.materialsList.count()
    }

    override fun onBindViewHolder(holder: LearningMaterialsViewHolder, position: Int) {
        holder.setData(this.materialsList[position])
    }
    fun setMaterialsList(materialsList : List<com.tpm.batch1.network.network_response.learning_material.LearningMaterial>)
    {
        this.materialsList = materialsList
        notifyDataSetChanged()
    }
}