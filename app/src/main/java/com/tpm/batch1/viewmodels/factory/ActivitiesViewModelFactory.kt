package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.ActivitiesRepository.ActivitiesRepository
import com.tpm.batch1.viewmodels.ActivitiesViewModel

class ActivitiesViewModelFactory(
    private val activityRepo: ActivitiesRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActivitiesViewModel(activityRepo) as T
    }
}