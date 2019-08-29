package com.tpm.batch1.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.ProfileRepository.ProfileRepository
import com.tpm.batch1.network.network_response.Profile.Profile
import io.reactivex.android.schedulers.AndroidSchedulers

class ProfileViewModel(
    private val profileRepo : ProfileRepository
) : BaseViewModel(){

    var profileGetSuccessState = MutableLiveData<Profile>()
    var profileGetErrorState = MutableLiveData<String>()

    fun loadProfile(studentId : String)
    {
        launch {
            profileRepo.getProfile(studentId)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("suc",it.address)
                    profileGetSuccessState.postValue(it)
                },{
                    Log.d("suc",it.localizedMessage)
                    profileGetErrorState.value = it.localizedMessage
                })
        }
    }
}