package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.learning_materials.view.*

class LearningMaterialsViewHolder(
    private val view: View,
    private val onClickPdfOpen: (material : com.tpm.batch1.network.network_response.learning_material.LearningMaterial) -> Unit
): RecyclerView.ViewHolder(view){
    fun setData(material : com.tpm.batch1.network.network_response.learning_material.LearningMaterial)
    {
        view.apply {
            tvViewText.text = material.fileName.toString().substring(0,1)
            tvMaterialTitle.text = material.fileName
        }
        view.setOnClickListener {
            onClickPdfOpen(material)
        }
    }
}