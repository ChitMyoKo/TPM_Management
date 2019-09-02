package com.tpm.batch1.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.dataclasses.SignInData
import com.tpm.batch1.data.repositories.SignInRepository.SignInRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class SigninViewModel(
    private val repo : SignInRepository
) : BaseViewModel() {

    var checkValidateState = MutableLiveData<String>()
    var validateMessageState = MutableLiveData<String>()

    fun checkSignInData(signInData: SignInData)
    {
        launch {
            repo.checkValidate(signInData)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    checkValidateState.postValue(it)
                },{
                    validateMessageState.value = it.localizedMessage
                })
        }
    }
}