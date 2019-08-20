package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.network.network_response.TeamMember
import com.tpm.batch1.ui.adapter.TeamMemberAdapter
import com.tpm.batch1.viewmodels.TeamMemberViewModel
import com.tpm.batch1.viewmodels.factory.TeamMemberViewModelFactory
import kotlinx.android.synthetic.main.activity_team_member.*

class TeamMemberActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,TeamMemberActivity::class.java)
            return intent
        }
    }

    private val teamMemberAdapter : TeamMemberAdapter by lazy { TeamMemberAdapter() }
    private val trainerViewModel : TeamMemberViewModel by lazy {
        ViewModelProviders.of(this, TeamMemberViewModelFactory(Injection.provideTeamMemberRepository(this)))
            .get(TeamMemberViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_member)
        recyclerTeamMember.apply {
            layoutManager = LinearLayoutManager(this@TeamMemberActivity)
            adapter = teamMemberAdapter
        }
        trainerViewModel.teamMemberListGetSuccessState.observe(this, Observer {
            teamMemberAdapter.setTeamMemberList(it)
        })
        trainerViewModel.teamMemberListGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        trainerViewModel.loadTrainerList()
    }
}
