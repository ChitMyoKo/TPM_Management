package com.tpm.batch1.data.repositories.LearningMaterials

import io.reactivex.Observable

interface LearningMaterialsRepository {
    fun getMaterialsList(trackId : String) : Observable<List<com.tpm.batch1.network.network_response.learning_material.LearningMaterial>>
}