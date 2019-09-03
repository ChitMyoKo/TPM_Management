package com.tpm.batch1.ui.adapter.viewholders

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
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
            var colorArr = arrayOf(R.drawable.green_bg,R.drawable.red_bg,R.drawable.black_bg,R.drawable.blue_bg)
            var r = 6
            Log.d("hello","hello")
            while(r > 4) {
                r = (Math.ceil(Math.random() * 10)).toInt()
                Log.d("rrr",r.toString())
            }
            viewBg.setBackgroundResource(colorArr[r-1])
        }
        view.setOnClickListener {
            onClickPdfOpen(material)
        }
    }
}