package com.tpm.batch1.data.repositories.LearningMaterials

import com.tpm.batch1.network.network_response.LearningMaterial
import io.reactivex.Observable

interface LearningMaterialsRepository {
    fun getMaterialsList() : Observable<List<LearningMaterial>>
}