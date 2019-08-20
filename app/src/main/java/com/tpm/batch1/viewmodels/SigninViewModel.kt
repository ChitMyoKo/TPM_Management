package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.dataclasses.SignInData
import com.tpm.batch1.data.repositories.SignInRepository.SignInRepository

class SigninViewModel(
    private val repo : SignInRepository
) : BaseViewModel() {

    var checkValidateState = MutableLiveData<SignInData>()
    var validateMessageState = MutableLiveData<String>()

}