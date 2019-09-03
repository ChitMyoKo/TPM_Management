package com.tpm.batch1.data.repositories.TeamMemberRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.team_member.TeamMember
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class TeamMemberRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : TeamMemberRepository {
    var t1 = TeamMember("koko@gmail.com","Ko","R.drawable.user","Ko","09345676","Java")
    var t2 = TeamMember("mama@gmail.com","Ma","R.drawable.user","Ma","09345676","Java")
    var tList = mutableListOf<TeamMember>(t1,t2)
    override fun getTrainerList(teamId : String): Observable<List<com.tpm.batch1.network.network_response.team_member.TeamMember>> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(tList)
            return apiService.loadTeamMemberList(teamId)
        }
        else
        {
            return Observable.just(tList)
        }
    }
}