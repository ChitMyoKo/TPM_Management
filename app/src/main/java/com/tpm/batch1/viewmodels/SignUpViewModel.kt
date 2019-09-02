package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.dataclasses.SignupData
import com.tpm.batch1.data.repositories.SignUpRepository.SignUpRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class SignUpViewModel(
    private val signupRepo : SignUpRepository
): BaseViewModel() {

    var signupSuccessState = MutableLiveData<String>()
    var signupErrorState = MutableLiveData<String>()
    fun checkSignInData(signIupData: SignupData)
    {
        launch {
            signupRepo.checkValidate(signIupData)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    signupSuccessState.postValue(it)
                },{
                    signupErrorState.value = it.localizedMessage
                })
        }
    }
}