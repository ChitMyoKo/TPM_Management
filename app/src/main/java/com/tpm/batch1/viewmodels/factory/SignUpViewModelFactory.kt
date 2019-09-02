package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.SignUpRepository.SignUpRepository
import com.tpm.batch1.viewmodels.SignUpViewModel

class SignUpViewModelFactory(
    private val signupRepo : SignUpRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(signupRepo) as T
    }
}