package com.tpm.batch1.data.repositories.LearningMaterials

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.LearningMaterial
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class LearningMaterialsRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : LearningMaterialsRepository{
    val lm1 = LearningMaterial("Kotlin Programming","https://kotlinlink")
    val lm2 = LearningMaterial("Android Development","https://kotlinlink")
    val lmList = mutableListOf<LearningMaterial>(lm1,lm2)
    override fun getMaterialsList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.learning_material.LearningMaterial>> {
        if(Utils.isOnline(context))
        {
            return apiService.loadLearningMaterialList(trackId)
        }
        else
        {
            return apiService.loadLearningMaterialList(trackId)
        }
    }
}