package com.tpm.batch1.ui.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.TeamMember
import kotlinx.android.synthetic.main.team_member.view.*
import kotlinx.android.synthetic.main.trainer.view.*

class TeamMemberViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view){
    fun setData(data : com.tpm.batch1.network.network_response.team_member.TeamMember)
    {
        view.apply {
            tvTeamMemberName.text = data.firstName+ " " + data.lastName
            tvTeamMemberJob.text = data.trackName
            tvTeamMemberEmail.text = data.email
            tvTeamMemberPhoneNumber.text = data.phone
            Picasso.get().load(data.imgLink).into(ivTeamMemberProfile)
        }
    }
}