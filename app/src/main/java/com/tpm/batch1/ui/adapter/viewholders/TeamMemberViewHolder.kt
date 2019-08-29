package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.TeamMember
import kotlinx.android.synthetic.main.team_member.view.*
import kotlinx.android.synthetic.main.trainer.view.*

class TeamMemberViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view){
    fun setData(data : List<String>)
    {
        view.apply {
            tvTeamMemberName.text = data[0]+" "+ data[1]
            tvTeamMemberJob.text = data[2]
            tvTeamMemberEmail.text = data[3]
            tvTeamMemberPhoneNumber.text = data[4]
            ivTeamMemberProfile.setImageResource(R.drawable.user)
        }
    }
}