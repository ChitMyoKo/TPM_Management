package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.network.network_response.TeamMember
import kotlinx.android.synthetic.main.team_member.view.*
import kotlinx.android.synthetic.main.trainer.view.*

class TeamMemberViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view){
    fun setData(data : TeamMember)
    {
        view.apply {
            tvTeamMemberName.text = data.teamMemberName
            tvTeamMemberJob.text = data.teamMemberJob
            tvTeamMemberEmail.text = data.teamMemberEmail
            tvTeamMemberPhoneNumber.text = data.teamMemberPhoneNumber
            ivTeamMemberProfile.setImageResource(data.teamMemberProfile)
        }
    }
}