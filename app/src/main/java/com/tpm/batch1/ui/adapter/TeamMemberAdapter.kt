package com.tpm.batch1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.network_response.TeamMember
import com.tpm.batch1.ui.adapter.viewholders.TeamMemberViewHolder

class TeamMemberAdapter: RecyclerView.Adapter<TeamMemberViewHolder>() {
    private var teamMemberList = emptyList<List<String>>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.team_member,parent,false)
        return TeamMemberViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.teamMemberList.count()
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        holder.setData(this.teamMemberList[position])
    }
    fun setTeamMemberList(trainerList: List<List<String>>)
    {
        this.teamMemberList = trainerList
        notifyDataSetChanged()
    }
}