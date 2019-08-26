package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.LearningMaterials.LearningMaterialsRepository
import com.tpm.batch1.viewmodels.LearningMaterialsViewModel

class LearningMaterialsViewModelFactory(
    private val learningMaterialsRepo : LearningMaterialsRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LearningMaterialsViewModel(learningMaterialsRepo) as T
    }

}