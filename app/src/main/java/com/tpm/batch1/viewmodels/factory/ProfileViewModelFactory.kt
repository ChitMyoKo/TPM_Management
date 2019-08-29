package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.ProfileRepository.ProfileRepository
import com.tpm.batch1.viewmodels.ProfileViewModel

class ProfileViewModelFactory(
    private val profileRepo : ProfileRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(profileRepo) as T
    }
}