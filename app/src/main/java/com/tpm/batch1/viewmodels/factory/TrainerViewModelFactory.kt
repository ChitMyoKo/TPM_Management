package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.TrainerRepository.TrainerRepository
import com.tpm.batch1.viewmodels.TrainerViewModel

class TrainerViewModelFactory (
    private val trainerRepo : TrainerRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrainerViewModel(trainerRepo) as T
    }
}