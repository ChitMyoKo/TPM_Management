package com.tpm.batch1.data.repositories.TeamMemberRepository

import android.content.Context
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.TeamMember
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class TeamMemberRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : TeamMemberRepository {
    override fun getTrainerList(): Observable<List<TeamMember>> {
        var t1 = TeamMember("Mr Chit Myo Ko","Android Developer", R.drawable.user,"kyaw@gmail.com","0945678")
        var t2 = TeamMember("Mr Ye Lin Aung","Android Developer",R.drawable.user,"myo@gmail.com","0945678")
        var teamMemberList = mutableListOf<TeamMember>(t1,t2)
        if(!Utils.isOnline(context))
        {
            return Observable.just(teamMemberList)
        }
        else
        {
            return Observable.just(teamMemberList)
        }
    }
}