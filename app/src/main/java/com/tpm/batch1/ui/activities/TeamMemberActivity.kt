package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.TeamMemberAdapter
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.TeamMemberViewModel
import com.tpm.batch1.viewmodels.factory.TeamMemberViewModelFactory
import kotlinx.android.synthetic.main.activity_team_member.*

class TeamMemberActivity : AppCompatActivity() {
    companion object {
        var teamId = ""
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, TeamMemberActivity::class.java)
            return intent
        }
    }

    private val teamMemberAdapter: TeamMemberAdapter by lazy { TeamMemberAdapter() }
    private val teamMemberViewModel: TeamMemberViewModel by lazy {
        ViewModelProviders.of(this, TeamMemberViewModelFactory(Injection.provideTeamMemberRepository(this)))
            .get(TeamMemberViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_member)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        teamMemberToolbar.setTitle(R.string.team_members)
        setSupportActionBar(teamMemberToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        teamId = "1"
        recyclerTeamMember.apply {
            layoutManager = LinearLayoutManager(this@TeamMemberActivity)
            adapter = teamMemberAdapter
        }
        if (Utils.isOnline(this)) {
            teamMemberViewModel.teamMemberListGetSuccessState.observe(this@TeamMemberActivity, Observer {
                teamMemberAdapter.setTeamMemberList(it)
            })
            teamMemberViewModel.teamMemberListGetErrorState.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
            teamMemberViewModel.loadTrainerList(teamId)
        } else {
            Toast.makeText(this, "Check your internet conection.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Injection.hideSystemUI(window)
    }
}
