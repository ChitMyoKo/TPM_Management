package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.LearningMaterial
import kotlinx.android.synthetic.main.learning_materials.view.*

class LearningMaterialsViewHolder(
    private val view: View
): RecyclerView.ViewHolder(view){
    fun setData(material : LearningMaterial)
    {
        view.apply {
            tvViewText.text = "K"
            tvMaterialTitle.text = material.materialTitle
        }
    }
}