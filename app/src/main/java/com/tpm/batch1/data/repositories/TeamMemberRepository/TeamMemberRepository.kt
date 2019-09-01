package com.tpm.batch1.data.repositories.TeamMemberRepository

import com.tpm.batch1.network.network_response.TeamMember
import io.reactivex.Observable

interface TeamMemberRepository {
    fun getTrainerList(teamId : String) : Observable<List<com.tpm.batch1.network.network_response.team_member.TeamMember>>
}