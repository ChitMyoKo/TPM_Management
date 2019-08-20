package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.SignInRepository.SignInRepository
import com.tpm.batch1.viewmodels.SigninViewModel

class SigninViewModelFactory(
    private val repo: SignInRepository
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SigninViewModel(repo) as T
    }
}