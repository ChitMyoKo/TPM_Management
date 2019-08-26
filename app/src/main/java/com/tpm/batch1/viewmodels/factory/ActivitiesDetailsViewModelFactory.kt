package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepository
import com.tpm.batch1.viewmodels.ActivitiesDetailsViewModel
import com.tpm.batch1.viewmodels.ActivitiesViewModel

class ActivitiesDetailsViewModelFactory(
    private val activitiesDetailsRepo : ActivitiesDetailsRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActivitiesDetailsViewModel(activitiesDetailsRepo) as T
    }
}