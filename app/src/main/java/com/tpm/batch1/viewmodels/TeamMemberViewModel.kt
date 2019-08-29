package com.tpm.batch1.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.TeamMemberRepository.TeamMemberRepository
import com.tpm.batch1.network.network_response.TeamMember
import io.reactivex.android.schedulers.AndroidSchedulers

class TeamMemberViewModel(
    private val teamMemberRepo : TeamMemberRepository
) : BaseViewModel() {
    var teamMemberListGetSuccessState = MutableLiveData<List<List<String>>>()
    var teamMemberListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList()
    {
        launch {
            teamMemberRepo.getTrainerList()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    teamMemberListGetSuccessState.postValue(it)
                    Log.d("xx",it.size.toString())
                },{
                    teamMemberListGetErrorState.value = it.localizedMessage
                    Log.d("xx",it.localizedMessage)
                })
        }
    }
}