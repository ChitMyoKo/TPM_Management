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
    override fun getTrainerList(teamId : String): Observable<List<com.tpm.batch1.network.network_response.team_member.TeamMember>> {
        if(!Utils.isOnline(context))
        {
            return apiService.loadTeamMemberList(teamId)
        }
        else
        {
            return apiService.loadTeamMemberList(teamId)
        }
    }
}