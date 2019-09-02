package com.tpm.batch1.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.repositories.TeamMemberRepository.TeamMemberRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class TeamMemberViewModel(
    private val teamMemberRepo : TeamMemberRepository
) : BaseViewModel() {
    var teamMemberListGetSuccessState = MutableLiveData<List<com.tpm.batch1.network.network_response.team_member.TeamMember>>()
    var teamMemberListGetErrorState = MutableLiveData<String>()

    fun loadTrainerList(teamId : String)
    {
        launch {
            teamMemberRepo.getTrainerList(teamId)
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