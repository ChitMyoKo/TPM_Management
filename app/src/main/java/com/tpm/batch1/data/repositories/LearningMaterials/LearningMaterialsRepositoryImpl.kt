package com.tpm.batch1.data.repositories.LearningMaterials

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.learning_material.LearningMaterial
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class LearningMaterialsRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : LearningMaterialsRepository{
    var l1 = LearningMaterial(2,2,2,"http:askdlf","How to download file",3,3,"3:00am")
    var l2 = LearningMaterial(2,2,2,"http:askdlf","How to upload file",3,3,"3:00am")
    var lList = mutableListOf<LearningMaterial>(l1,l2)
    override fun getMaterialsList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.learning_material.LearningMaterial>> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(lList)
            return apiService.loadLearningMaterialList(trackId)
        }
        else
        {
            return Observable.just(lList)
        }
    }
}